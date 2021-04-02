package com.yamauchi.lista01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.yamauchi.lista01.databinding.ActivityExe03Binding

class Exe03Activity : AppCompatActivity() {
    lateinit var binding: ActivityExe03Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExe03Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val emailTypes = arrayOf("Select the email type", "Personal", "Professional", "Other")
        val emailTypesAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, emailTypes)
        emailTypesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val messageApps = arrayOf("Select the message app", "WhatsApp", "Telegram", "Signal", "Discord", "Skype")
        val messageAppsAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, messageApps)
        messageAppsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spnMessageApp03.adapter = messageAppsAdapter
        binding.spnEmailType03.adapter = emailTypesAdapter

        binding.btnSave03.setOnClickListener {
            val msg = """Name: ${binding.txtName03.text}
                |Email type: ${binding.spnEmailType03.selectedItem}
                |Email: ${binding.txtEmail03.text}
                |Message app: ${binding.spnMessageApp03.selectedItem}
                |Telefone: ${binding.txtPhone03.text}
            """.trimMargin("|")

            alert("Concluido", msg, this)
        }
    }
}