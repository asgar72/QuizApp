package com.asgar72.quizapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import androidx.core.content.ContextCompat
import com.asgar72.quizapp.R
import com.asgar72.quizapp.databinding.ActivityMain1Binding

class MainActivity1 : AppCompatActivity() {
    lateinit var binding: ActivityMain1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        val window:Window=this@MainActivity1.window
        window.statusBarColor=ContextCompat.getColor(this@MainActivity1, R.color.grey)


    }
}