package com.yamauchi.lista01

import android.content.Context
import androidx.appcompat.app.AlertDialog

fun alert(title:String, msg: String, context: Context){

    AlertDialog.Builder(context)
        .setTitle(title)
        .setMessage(msg)
        .setPositiveButton("OK", null)
        .create()
        .show()
}