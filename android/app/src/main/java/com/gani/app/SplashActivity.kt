package com.gani.app

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView

class SplashActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = Color.rgb(1, 7, 20)
        window.navigationBarColor = Color.rgb(1, 7, 20)
        val image = ImageView(this).apply {
            setImageResource(com.gani.app.R.drawable.gani_splash_screen_v34)
            scaleType = ImageView.ScaleType.CENTER_CROP
            setBackgroundColor(Color.rgb(1, 7, 20))
            systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        }
        setContentView(image)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 1100)
    }
}
