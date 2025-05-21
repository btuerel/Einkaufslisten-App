package com.example.einkaufsliste

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ArticleAdapter(
    private val artikelListe: List<String>,
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvArtikel: TextView = view.findViewById(R.id.tvArtikel)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_article, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val artikel = artikelListe[position]
        holder.tvArtikel.text = artikel
        holder.itemView.setOnClickListener { onClick(artikel) }
    }

    override fun getItemCount(): Int = artikelListe.size
}
