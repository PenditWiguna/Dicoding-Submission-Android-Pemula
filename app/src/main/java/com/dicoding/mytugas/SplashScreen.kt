@file:Suppress("DEPRECATION")

package com.dicoding.mytugas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {

	private val SPLASH_TIME_OUT: Long = 2000 // 2 detik

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_splash_screen)

		Handler().postDelayed({
			// Intent untuk berpindah ke MainActivity setelah splash screen selesai
			val intent = Intent(this, MainActivity::class.java)
			startActivity(intent)

			// Tutup SplashScreenActivity agar tidak dapat dikembali ke layar splash screen
			finish()
		}, SPLASH_TIME_OUT)
	}


}