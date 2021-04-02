package com.yamauchi.lista01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yamauchi.lista01.databinding.ActivityExe05Binding

class Exe05Activity : AppCompatActivity() {
    lateinit var binding: ActivityExe05Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExe05Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnsNum = arrayOf(binding.btnNum005,binding.btnNum105, binding.btnNum205, binding.btnNum305, binding.btnNum405, binding.btnNum505, binding.btnNum605, binding.btnNum705, binding.btnNum805, binding.btnNum905)
        val calc = arrayListOf<String>()
        btnsNum.forEach {
            val btnTitle = it.text.toString()
            it.setOnClickListener {
                calc.add(btnTitle)
                print(calc)
            }
        }
    }
}