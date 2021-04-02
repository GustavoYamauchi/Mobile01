package com.yamauchi.lista01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yamauchi.lista01.databinding.ActivityExe07DetalheBinding

class Exe07DetalheActivity : AppCompatActivity() {
    lateinit var binding: ActivityExe07DetalheBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExe07DetalheBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstName = intent.getStringExtra("firstName")
        val lastName = intent.getStringExtra("lastName")

        val msg = "$firstName $lastName"

        alert("Concluido", msg, this)
    }
}