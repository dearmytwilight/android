package edu.sungshin.baseballclub

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import android.content.SharedPreferences
import android.content.Context
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class register : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    private val PREF_NAME = "UserPrefs"
    private val KEY_EMAIL = "email"
    private val KEY_LOGIN_STATUS = "login_status"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        // Firebase 초기화
        FirebaseApp.initializeApp(this)

        // Firebase 인증 인스턴스 생성
        auth = Firebase.auth

        val r_email = findViewById(R.id.r_email) as EditText
        val r_password = findViewById(R.id.r_password) as EditText
        val checkPasswordId = findViewById(R.id.checkpwd) as EditText

        val completeregisterbutton = findViewById<Button>(R.id.completeregisterbutton)
        completeregisterbutton.setOnClickListener {

            val r_email: String = r_email.text.toString()
            val r_password: String = r_password.text.toString()
            val checkPassword: String = checkPasswordId.text.toString()

            // 필드가 비어 있는지 확인
            if (r_email.isEmpty() || r_password.isEmpty() || checkPassword.isEmpty()) {
                Toast.makeText(baseContext, "이메일과 비밀번호를 모두 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (r_password != checkPassword) {
                // 비밀번호와 비밀번호 확인이 일치하지 않을 경우
                Toast.makeText(
                    baseContext,
                    "비밀번호와 비밀번호 확인이 일치하지 않습니다.",
                    Toast.LENGTH_SHORT
                ).show()

            } else {
                // 비밀번호와 비밀번호 확인이 일치할 경우
                auth.createUserWithEmailAndPassword(r_email, r_password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // 회원가입 성공
                            val user = auth.currentUser
                            val sharedPreferences: SharedPreferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
                            val editor = sharedPreferences.edit()
                            if (user != null) {
                                editor.putString(KEY_EMAIL, user.email)
                                editor.putString(KEY_LOGIN_STATUS, "로그인됨")
                                editor.apply()

                                // 로그인 성공 화면으로 이동
                                val intent = Intent(this, LoginSuccessActivity::class.java)
                                startActivity(intent)
                                finish()
                            }

                        }

                        else {
                            // 회원가입 실패

                            val exception = task.exception
                            if (exception is FirebaseAuthUserCollisionException) {
                                // 이미 사용 중인 이메일 주소
                                Toast.makeText(baseContext, "이미 있는 계정입니다.", Toast.LENGTH_SHORT).show()
                            } else if (exception is FirebaseAuthInvalidCredentialsException) {
                                // 잘못된 이메일 형식
                                Toast.makeText(baseContext, "잘못된 이메일 형식으로 입력하셨습니다.", Toast.LENGTH_SHORT).show()
                            } else if (exception is FirebaseAuthWeakPasswordException) {
                                // 비밀번호가 너무 간단함
                                Toast.makeText(baseContext, "비밀번호가 8자리 이하입니다.", Toast.LENGTH_SHORT).show()
                            } else {
                                // 기타 예외 처리
                                Log.w(TAG, "createUserWithEmail:failure", exception)
                                Toast.makeText(baseContext, "회원가입 실패: ${exception?.message}", Toast.LENGTH_SHORT).show()
                            }
                            updateUI(null)
                        }
                    }
            }
        }
    }

    private fun updateUI(user: FirebaseUser?) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            reload()
        }
    }

    private fun reload() {
        // Implement your reload logic here if needed
    }
}
