package com.exer7um.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    var BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        BottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        supportFragmentManager.beginTransaction().replace(R.id.layout, Football()).commit()
    }
}