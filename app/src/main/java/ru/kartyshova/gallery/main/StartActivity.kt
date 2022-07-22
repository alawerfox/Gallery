package ru.kartyshova.gallery.main

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.kartyshova.gallery.main.data.api.apiModule
import ru.kartyshova.gallery.main.presentation.MainActivity
import ru.kartyshova.gallery.main.presentation.gallery.galleryModule
import ru.kartyshova.gallery.main.presentation.login.loginModule

class StartActivity : AppCompatActivity() {

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            androidContext(this@StartActivity)
            modules(listOf(
                apiModule,
                loginModule,
                galleryModule

            ))
        }

        handler.postDelayed({
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }, 500L)
    }
}