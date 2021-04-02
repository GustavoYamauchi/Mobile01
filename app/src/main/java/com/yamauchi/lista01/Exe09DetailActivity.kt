package com.yamauchi.lista01

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yamauchi.lista01.databinding.ActivityExe09DetailBinding

class Exe09DetailActivity : AppCompatActivity() {
    lateinit var binding : ActivityExe09DetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExe09DetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configBtn(intent.getFloatExtra("val1", 1.0F), intent.getFloatExtra("val2", 1.0F))    }

    fun configBtn(val1: Float, val2: Float) {
        val aIntent = Intent()
        binding.btnDiv09.setOnClickListener {
            aIntent.putExtra("Result", val1 / val2)
            setResult(Activity.RESULT_OK, aIntent)
            finish()
        }
        binding.btnMulti09.setOnClickListener {
            aIntent.putExtra("Result", val1 * val2)
            setResult(Activity.RESULT_OK, aIntent)
            finish()
        }
        binding.btnSub09.setOnClickListener {
            aIntent.putExtra("Result", val1 - val2)
            setResult(Activity.RESULT_OK, aIntent)
            finish()
        }
        binding.btnSum09.setOnClickListener {
            aIntent.putExtra("Result", val1 + val2)
            setResult(Activity.RESULT_OK, aIntent)
            finish()
        }
    }
}
