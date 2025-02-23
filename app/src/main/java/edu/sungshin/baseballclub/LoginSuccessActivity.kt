package edu.sungshin.baseballclub

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginSuccessActivity : AppCompatActivity() {
    private lateinit var emailTextView: TextView
    private lateinit var loginStatusTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_success)

        emailTextView = findViewById(R.id.emailTextView)
        loginStatusTextView = findViewById(R.id.loginStatusTextView)

        // 로그인된 사용자의 정보를 FirebaseAuth에서 가져옵니다.
        val user = Firebase.auth.currentUser
        if (user != null) {
            // 로그인된 경우, 이메일과 "로그인됨" 상태를 표시합니다.
            emailTextView.text = user.email
            loginStatusTextView.text = "로그인됨"
        } else {
            // 로그인되지 않은 경우 처리 (로그인되지 않으면 이 페이지에 도달할 수 없지만, 안전 장치로 넣을 수 있습니다)
            emailTextView.text = "로그인되지 않음"
            loginStatusTextView.text = "로그인되지 않음"
        }
    }
}
