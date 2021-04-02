package com.yamauchi.lista01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yamauchi.lista01.databinding.ActivityExe06ImageBinding

class Exe06ImageActivity : AppCompatActivity() {
    lateinit var binding: ActivityExe06ImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExe06ImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val picture = intent.getIntExtra("picture", R.drawable.img1);

        binding.imgFull06.setImageResource(picture)
        binding.imgFull06.tag = picture
    }
}