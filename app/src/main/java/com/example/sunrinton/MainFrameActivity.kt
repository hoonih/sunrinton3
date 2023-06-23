package com.example.sunrinton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainFrameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_frame)

        var bnv_main = findViewById(R.id.bnv_main) as BottomNavigationView
        bnv_main.run {
            setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.menu_main_home -> { // 다른 프래그먼트 화면으로 이동하는 기능
                        val BlankFragment1 = HomeFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fl_con, BlankFragment1).commit()
                    }
                    R.id.menu_main_search -> { // 다른 프래그먼트 화면으로 이동하는 기능
                        val BlankFragment1 = SearchFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.fl_con, BlankFragment1).commit()
                    }
                }
                true
            }
            selectedItemId = R.id.menu_main_home
        }
    }
}