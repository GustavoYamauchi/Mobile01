package com.yamauchi.lista01

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
import com.yamauchi.lista01.databinding.ActivityExe08Binding

class Exe08Activity : AppCompatActivity() {
    lateinit var binding: ActivityExe08Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExe08Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSearch08.setOnClickListener {
            val uri = Uri.parse(binding.txtUrl08.text.toString())
            CustomTabsIntent.Builder()
                    .build()
                    .launchUrl(this, uri)
        }
    }
}
