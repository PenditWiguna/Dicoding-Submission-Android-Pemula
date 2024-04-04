@file:Suppress("DEPRECATION")

package com.dicoding.mytugas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailDestinasi : AppCompatActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_detail_destinasi)

		val destinasi = intent.getParcelableExtra<Destinasi>("EXTRA_DESTINASI")

		val imgPhoto: ImageView = findViewById(R.id.img_detail_photo)
		val tvName: TextView = findViewById(R.id.tv_detail_name)
		val tvDescription: TextView = findViewById(R.id.tv_detail_description)

		destinasi?.let {
			imgPhoto.setImageResource(it.photo)
			tvName.text = it.name
			tvDescription.text = it.detailDescription
		}
	}
}