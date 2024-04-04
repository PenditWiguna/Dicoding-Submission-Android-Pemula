package com.dicoding.mytugas

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ListDestinasiAdapter.OnItemClickListener {
    private lateinit var rvDestinasi: RecyclerView
    private val list = ArrayList<Destinasi>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvDestinasi = findViewById(R.id.rv_destinasi)

        list.addAll(getListDestinasi())
        showRecyclerList()
    }

    private fun showRecyclerList() {
        val listDestinasiAdapter = ListDestinasiAdapter(list)
        listDestinasiAdapter.setOnItemClickListener(this)
        rvDestinasi.adapter = listDestinasiAdapter
        rvDestinasi.layoutManager = LinearLayoutManager(this)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_page -> {
                val intent = Intent(this, TentangView::class.java)
                startActivity(intent)
            }

        }
        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("Recycle")
    private fun getListDestinasi(): ArrayList<Destinasi> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val detailDescription = resources.getStringArray(R.array.detail_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listDestinasi = ArrayList<Destinasi>()
        for (i in dataName.indices) {
            val Destinasi =
                Destinasi(dataName[i], dataDescription[i], detailDescription[i], dataPhoto
                    .getResourceId(i, -1))
            listDestinasi.add(Destinasi)
        }
        return listDestinasi

    }

    override fun onItemClick(destinasi: Destinasi) {
        val intent = Intent(this, DetailDestinasi::class.java)
        intent.putExtra("EXTRA_DESTINASI", destinasi)
        startActivity(intent)
    }

}