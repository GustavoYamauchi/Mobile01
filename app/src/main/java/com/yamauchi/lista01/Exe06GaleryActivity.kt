package com.yamauchi.lista01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yamauchi.lista01.databinding.ActivityExe06GaleryBinding

class Exe06GaleryActivity : AppCompatActivity() {
    lateinit var binding: ActivityExe06GaleryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExe06GaleryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.img106.tag = R.drawable.img1
        binding.img206.tag = R.drawable.img10
        binding.img306.tag = R.drawable.img11
        binding.img406.tag = R.drawable.img4

        val imgs = arrayOf(binding.img106, binding.img206, binding.img306, binding.img406)

        imgs.forEach {
            imageView ->
            run {
                imageView.setOnClickListener {
                    val intent = Intent(this, Exe06ImageActivity::class.java)
                    intent.putExtra("picture", imageView.tag as Int)

                    startActivity(intent)
                }
            }
        }
    }
}