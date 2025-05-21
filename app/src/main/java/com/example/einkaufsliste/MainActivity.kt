package com.example.einkaufsliste

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val artikelListe = mutableListOf<String>()
    private lateinit var adapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val artikelInput = findViewById<EditText>(R.id.etArtikel)
        val hinzufuegenButton = findViewById<Button>(R.id.btnHinzufuegen)
        val recyclerView = findViewById<RecyclerView>(R.id.rvArtikel)

        adapter = ArticleAdapter(artikelListe) { artikel ->
            artikelListe.remove(artikel)
            adapter.notifyDataSetChanged()
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        hinzufuegenButton.setOnClickListener {
            val artikel = artikelInput.text.toString()
            if (artikel.isNotBlank()) {
                artikelListe.add(artikel)
                artikelInput.text.clear()
                adapter.notifyDataSetChanged()
            }
        }
    }
}
