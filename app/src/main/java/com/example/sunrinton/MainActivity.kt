package com.example.sunrinton

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.sunrinton.databinding.ActivityMainBinding
import com.example.sunrinton.databinding.ActivityTestBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)




        firebaseAuth = FirebaseAuth.getInstance()

        binding.loginbutton.setOnClickListener {

            val email = binding.edittextemail.text.toString()
            val pass = binding.edittextpassword.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, pass)
                    .addOnCompleteListener {                 //파이어베이스 회원가입
                        if (it.isSuccessful) {
                            Toast.makeText(this, "로그인을 성공하였습니다", Toast.LENGTH_SHORT).show()

                            val intent = Intent(this, MainFrameActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                        }

                    }

            } else {
                Toast.makeText(this, "모든 칸을 입력해 주세요.", Toast.LENGTH_SHORT).show()

            }
        }
        binding.registerbutton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

    }


}