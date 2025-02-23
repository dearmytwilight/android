package edu.sungshin.baseballclub

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.ktx.auth
import androidx.appcompat.app.AppCompatActivity

class MyPageFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginbutton: Button
    private lateinit var logoutButton: Button
    private lateinit var registerbutton: Button

    companion object {
        fun getInstance(): MyPageFragment {
            return MyPageFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the fragment layout
        val view = inflater.inflate(R.layout.fragment_my_page, container, false)
        var registerbutton = view.findViewById<Button>(R.id.registerbutton)

        registerbutton.setOnClickListener {
            var intent = Intent(activity, register::class.java)
            startActivity(intent)
        }

        auth = Firebase.auth
        val loginbutton = view.findViewById<Button>(R.id.loginbutton)

        loginbutton.setOnClickListener {
            val email = view.findViewById<EditText>(R.id.email).text.toString()
            val password = view.findViewById<EditText>(R.id.password).text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "이메일과 비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        updateUI(user)
                        Toast.makeText(requireContext(), "로그인 되었습니다.", Toast.LENGTH_SHORT).show()
                    } else {
                        updateUI(null, showError = true)  // 로그인 실패 시만 오류 메시지 표시
                    }
                }

        }

        val logoutButton = view.findViewById<Button>(R.id.logoutButton)

        // 로그아웃 버튼 클릭 리스너 설정
        logoutButton.setOnClickListener {
            auth.signOut() // Firebase 로그아웃 처리
            updateUI(null) // UI 초기 상태로 복원
            Toast.makeText(requireContext(), "로그아웃되었습니다.", Toast.LENGTH_SHORT).show()
        }

        return view

    }

    private fun updateUI(user: FirebaseUser?, showError: Boolean = false) {
        val emailEditText = view?.findViewById<EditText>(R.id.email)
        val passwordEditText = view?.findViewById<EditText>(R.id.password)
        val loginButton = view?.findViewById<Button>(R.id.loginbutton)
        val registerButton = view?.findViewById<Button>(R.id.registerbutton)
        val loginStatusText = view?.findViewById<TextView>(R.id.loginStatusText)
        val logoutButton = view?.findViewById<Button>(R.id.logoutButton)

        if (user != null) {
            emailEditText?.visibility = View.GONE
            passwordEditText?.visibility = View.GONE
            loginButton?.visibility = View.GONE
            registerButton?.visibility = View.GONE
            logoutButton?.visibility = View.VISIBLE
            loginStatusText?.text = "로그인됨"
            loginStatusText?.visibility = View.VISIBLE
        } else {
            emailEditText?.visibility = View.VISIBLE
            passwordEditText?.visibility = View.VISIBLE
            loginButton?.visibility = View.VISIBLE
            registerButton?.visibility = View.VISIBLE
            logoutButton?.visibility = View.GONE
            loginStatusText?.text = " "
            loginStatusText?.visibility = View.GONE

            if (showError) {
                Toast.makeText(requireContext(), "로그인에 실패했습니다. 다시 확인해 주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }


    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        updateUI(currentUser, showError = false)  // 초기 상태에서는 오류 메시지 표시하지 않음
    }


    private fun reload() {
        // 필요한 경우 리로드 로직 구현
    }
}



