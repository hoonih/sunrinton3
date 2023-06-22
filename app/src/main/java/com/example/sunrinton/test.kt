package com.example.sunrinton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sunrinton.databinding.ActivityMainBinding
import com.example.sunrinton.databinding.ActivityTestBinding

class test : AppCompatActivity() {

    private lateinit var binding: ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityTestBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val id = intent.getStringExtra("id")
        val pw = intent.getStringExtra("pw")
        binding.edittext1.setText("아이디: ${id}\n패스워드: ${pw}")
    }
}