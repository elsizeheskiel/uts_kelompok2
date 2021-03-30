package com.example.uts_kelompok2

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private lateinit var dataNama: Array<String>
    private lateinit var dataDeskripsi: Array<String>
    private lateinit var dataFoto: TypedArray
    private lateinit var adapter: FilmAdapter
    private var film_ = arrayListOf<Film>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView: ListView = findViewById(R.id.lv_film)
        adapter = FilmAdapter(this)
        listView.adapter = adapter

        prepare()
        addItem()
    }
    private fun prepare() {
        dataNama = resources.getStringArray(R.array.data_nama)
        dataDeskripsi = resources.getStringArray(R.array.data_deskripsi)
        dataFoto = resources.obtainTypedArray(R.array.data_foto)
    }
    private fun addItem() {
        for (position in dataNama.indices) {
            val film = Film(
                    dataNama[position],
                    dataDeskripsi[position],
                    dataFoto.getResourceId(position, -1)
            )
            film_.add(film)
        }
        adapter.film = film_
    }
}
