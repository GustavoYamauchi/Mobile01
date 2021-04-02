package com.yamauchi.lista01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yamauchi.lista01.databinding.ActivityExe01Binding

class Exe01Activity : AppCompatActivity() {
    lateinit var binding: ActivityExe01Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExe01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFinish01.setOnClickListener {
            val msg = """ Nome: ${binding.txtName01.text}
                |Telefone: ${binding.txtPhone01.text}
                |Email: ${binding.txtEmail01.text}
                |WhatsApp: ${binding.txtWhats01.text}
                |
                |Contato Por:
                |Telefone: ${binding.cboPhone01.isChecked}
                |Email: ${binding.cboEmail01.isChecked}
                |WhatsApp: ${binding.cboWhatsApp01.isChecked}
            """.trimMargin("|")

            alert("Concluido", msg, this)
        }
    }
}