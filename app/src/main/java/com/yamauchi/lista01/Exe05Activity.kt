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
                binding.txtCalc05.text = binding.txtCalc05.text.toString() + btnTitle
                calc.add(btnTitle)
            }
        }

        val btnsOp = arrayOf(binding.btnDiv05, binding.btnMulti05, binding.btnSub05, binding.btnSum05, binding.btnDot05)
        btnsOp.forEach {
            val op = it.text.toString()
            it.setOnClickListener {
                var expression = binding.txtCalc05.text.toString()
                if (expression.isNotEmpty()) {
                    if (expression.last() !in "÷×-+." && op !in ".") {
                        binding.txtCalc05.text = expression + op
                        calc.add(op)
                    } else if (op in ".") {
                        var i = expression.length - 1
                        if (expression.last() !in "÷×-+") {
                            while (i >= 0) {
                                if (expression[i] in ".") break
                                if (expression[i] in "÷×-+" || i == 0) {
                                    binding.txtCalc05.text = binding.txtCalc05.text.toString() + "."
                                    break
                                }
                                i--
                            }
                        }
                    } else if (expression.last() != op.last()) {
                        expression = expression.dropLast(1)
                        expression += op
                        binding.txtCalc05.text = expression
                        calc.add(op)
                    }
                }
            }
        }

        binding.btnDel05.setOnClickListener {
            binding.txtCalc05.text = binding.txtCalc05.text.toString().dropLast(1)
        }

        binding.btnEquals05.setOnClickListener {
            var expression = binding.txtCalc05.text.toString()
            var nums = ArrayList<String>(expression.split("(÷|×|-|\\+)".toRegex()))
            var ops = ArrayList<String>()
            expression.forEach { if (it in "÷×-+") ops.add(it.toString()) }
            var i = 0
            var newNum = 0.toFloat()
            var highPrecedence = true
            while (nums.size > 1) {
                when (ops[i]) {
                    "÷" -> {
                        if (highPrecedence) {
                            newNum = nums[i].toFloat() / nums[i + 1].toFloat()
                            nums[i] = newNum.toString()
                            nums.removeAt(i + 1)
                            ops.removeAt(i)
                        }
                        else i++
                    }
                    "×" -> {
                        if (highPrecedence) {
                            newNum = nums[i].toFloat() * nums[i + 1].toFloat()
                            nums[i] = newNum.toString()
                            nums.removeAt(i + 1)
                            ops.removeAt(i)
                        }
                        else i++
                    }
                    "+" -> {
                        if (!highPrecedence) {
                            newNum = nums[i].toFloat() + nums[i + 1].toFloat()
                            nums[i] = newNum.toString()
                            nums.removeAt(i + 1)
                            ops.removeAt(i)
                        }
                        else i++
                    }
                    "-" -> {
                        if (!highPrecedence) {
                            newNum = nums[i].toFloat() - nums[i + 1].toFloat()
                            nums[i] = newNum.toString()
                            nums.removeAt(i + 1)
                            ops.removeAt(i)
                        }
                        else i++
                    }
                }
                if (i > ops.size - 1 && highPrecedence){
                    i = 0
                    highPrecedence = false
                }
            }
            binding.txtResult05.text = newNum.toString()
        }
    }
}