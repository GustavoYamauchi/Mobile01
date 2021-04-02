package com.yamauchi.lista01

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.yamauchi.lista01.databinding.ActivityExe04Binding
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener


class Exe04Activity : AppCompatActivity() {
    lateinit var binding: ActivityExe04Binding
    var typesToKinda = mapOf(
        "Movie" to arrayOf("Adventure", "Comedy", "Drama", "Romance", "Terror"),
        "Music" to arrayOf("Rock", "Pop", "Rap", "Funk", "Indie", "Reggae"),
        "Book" to arrayOf("Biography", "Mystery", "Humor", "Horror", "Suspense", "Romance"),
        "Games" to arrayOf("Action", "Adventure", "Simulation", "Strategy", "RPG", "Puzzle")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExe04Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val types = typesToKinda.keys.toTypedArray()
        val typesAdapter = ArrayAdapter(this, R.layout.simple_spinner_item, types)
        typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.spnType04.adapter = typesAdapter

        binding.spnType04.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                val genres = typesToKinda[parent.selectedItem]

                val genresAdapter = ArrayAdapter(parent.context, R.layout.simple_spinner_item, genres!!)
                genresAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

                binding.spnKinda04.adapter = genresAdapter
            }
        }

        binding.btnSave04.setOnClickListener {
            val msg = """Type: ${binding.spnType04.selectedItem}
                |Genre: ${binding.spnKinda04.selectedItem}
            """.trimMargin("|")

            alert("Concluido", msg, this)
        }
    }
}