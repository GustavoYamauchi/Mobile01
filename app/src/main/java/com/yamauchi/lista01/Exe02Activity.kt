package com.yamauchi.lista01

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.EditText
import com.yamauchi.lista01.databinding.ActivityExe02Binding

class Exe02Activity : AppCompatActivity() {
    lateinit var binding: ActivityExe02Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExe02Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val txts = arrayOf(binding.txtPhone02, binding.txtEmail02, binding.txtWhats02)

        configCheck(binding.cboPhone02, binding.txtPhone02)
        configCheck(binding.cboEmail02, binding.txtEmail02)
        configCheck(binding.cboWhatsApp02, binding.txtWhats02)


        txts.forEach {
            it.isEnabled = false
        }

        binding.btnFinish02.setOnClickListener {
            verifyFinish(txts)
        }
    }

    fun verifyText(txt: EditText) {
        txt.setText("")
        txt.isEnabled = !txt.isEnabled
    }

    fun configCheck(cbo: CheckBox, txt: EditText){
        cbo.setOnCheckedChangeListener { buttonView, isChecked ->  verifyText(txt)}
    }

    fun verifyFinish(txts: Array<EditText>){
        var txtsVoid = """ Os campos selecionados não possuem valor ou estão incorretos
            |
        """.trimMargin("|")
        var countVoid = 0
        txts.forEach {
            if (it.isEnabled) {
                if (it.text.isEmpty()) {
                    txtsVoid += """
                        |"${it.hint}" 
                    """.trimMargin("|")
                    countVoid++
                }
            }
        }

        if (countVoid > 0){
            alert("Erro", txtsVoid, this)
        }
        else {
            val msg = """ Nome: ${binding.txtName02.text}
                |Telefone: ${binding.txtPhone02.text}
                |Email: ${binding.txtEmail02.text}
                |WhatsApp: ${binding.txtWhats02.text}
                |
                |Contato Por:
                |Telefone: ${binding.cboPhone02.isChecked}
                |Email: ${binding.cboEmail02.isChecked}
                |WhatsApp: ${binding.cboWhatsApp02.isChecked}
            """.trimMargin("|")
            alert("Concluido", msg, this)
        }
    }
}