package com.example.sunrinton

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.sunrinton.databinding.ActivityMainBinding
import com.example.sunrinton.databinding.ActivityTestBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.loginbutton.setOnClickListener {
            Toast.makeText(this, "버튼을 눌렀습니다. ", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, search::class.java)
            var id = binding.edittextid.text.toString()
            var pw = binding.edittextpassword.text.toString()

            intent.putExtra("id", "${id}")
            intent.putExtra("pw", "${pw}")
            startActivity(intent)
        }

    }
}