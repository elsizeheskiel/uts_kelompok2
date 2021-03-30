package com.example.uts_kelompok2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class FilmAdapter constructor(private val context: Context) : BaseAdapter(){

    internal var film = arrayListOf<Film>()
    override fun getCount(): Int = film.size

    override fun getItem(i: Int): Any = film[i]

    override fun getItemId(i: Int): Long = i.toLong()
    override fun getView(position: Int, v: View?, viewGroup: ViewGroup): View {
        var itemView = v
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_film, viewGroup, false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val _film = getItem(position) as Film
        viewHolder.bind(_film)
        return itemView
    }
    private inner class ViewHolder constructor(view: View) {
        private val tvNama: TextView = view.findViewById(R.id.tv_nama)
        private val tvDeskripsi: TextView = view.findViewById(R.id.tv_deskripsi)
        private val imgFoto: ImageView = view.findViewById(R.id.img_item_photo)
        fun bind(film: Film) {
            tvNama.text = film.nama
            tvDeskripsi.text = film.deskripsi
            imgFoto.setImageResource(film.foto)
        }
    }
}