package com.yamauchi.lista01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yamauchi.lista01.databinding.ActivityExe07Binding

class Exe07Activity : AppCompatActivity() {
    lateinit var binding: ActivityExe07Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExe07Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShow07.setOnClickListener {
            val intent = Intent(this, Exe07DetalheActivity::class.java)

            intent.putExtra("firstName", binding.txtFirstName07.text.toString())
            intent.putExtra("lastName", binding.txtLastName07.text.toString())

            startActivity(intent)
        }
    }
}