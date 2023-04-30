package com.example.hardwarestoreappmvvm.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hardwarestoreappmvvm.R
import com.example.hardwarestoreappmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null)
            NavigationStrategy.Replace(StartFragment())
                .navigate(supportFragmentManager, R.id.container)
    }
}
