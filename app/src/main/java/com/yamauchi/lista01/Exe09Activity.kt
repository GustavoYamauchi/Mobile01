package com.yamauchi.lista01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.yamauchi.lista01.databinding.ActivityExe09Binding

class Exe09Activity : AppCompatActivity() {
    lateinit var binding: ActivityExe09Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExe09Binding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCallIntent09.setOnClickListener { verifyFinish(arrayOf(binding.txtVal109, binding.txtVal209)) }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.let {
            binding.txtResult09.setText(it.getFloatExtra("Result", 0F).toString())
        }
    }

    fun verifyFinish(txts: Array<EditText>) {
        var txtsVoid = """ Os campos selecionados não possuem valor ou estão incorretos
            |
        """.trimMargin("|")
        var countVoid = 0
        txts.forEach {
                if (it.text.isEmpty()) {
                    txtsVoid += """
                        |"${it.hint}" 
                    """.trimMargin("|")
                    countVoid++
                }
        }
        if (countVoid > 0){
            alert("Erro", txtsVoid, this)
        }
        else {
            val val1 = binding.txtVal109.text.toString().toFloat()
            val val2 = binding.txtVal209.text.toString().toFloat()
            callIntent(val1, val2)
        }
    }

    fun callIntent(val1: Float, val2: Float) {
        val intent = Intent(this,  Exe09DetailActivity::class.java)
//        intent.putExtra("values", arrayOf(val1, val2))
        intent.putExtra("val1", val1)
        intent.putExtra("val2", val2)
        startActivityForResult(intent, 0)
    }
}