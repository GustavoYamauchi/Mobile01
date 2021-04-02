package com.yamauchi.lista01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yamauchi.lista01.databinding.ActivityExe10Binding

class Exe10Activity : AppCompatActivity() {
    lateinit var binding : ActivityExe10Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExe10Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val btns = arrayOf(binding.btnLaunchEx1, binding.btnLaunchEx2, binding.btnLaunchEx3, binding.btnLaunchEx4, binding.btnLaunchEx5, binding.btnLaunchEx6, binding.btnLaunchEx7, binding.btnLaunchEx8, binding.btnLaunchEx9)
        val activities = arrayOf(Exe01Activity::class.java, Exe02Activity::class.java, Exe03Activity::class.java, Exe04Activity::class.java, Exe05Activity::class.java, Exe06GaleryActivity::class.java, Exe07Activity::class.java, Exe08Activity::class.java, Exe09Activity::class.java)

        btns.forEachIndexed { index, button ->
            button.setOnClickListener {
                val intent = Intent(this,  activities[index])
                startActivity(intent)
            }
        }
    }
}