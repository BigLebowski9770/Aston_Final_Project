package com.kipreev.aston_final_project.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.kipreev.aston_final_project.R

class SplashScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val logo: ImageView = findViewById(R.id.splash_logo)
        val textPic : ImageView = findViewById(R.id.text_rick_and_mort_pic)
        val icon: ImageView = findViewById(R.id.splash_icon)

        logo.alpha = 0f
        textPic.alpha = 0f
        icon.alpha = 0f

        logo.animate().setDuration(800).alpha(1f).withEndAction {

            textPic.animate().setDuration(800).alpha(1f).withEndAction{

            icon.animate().setDuration(800).alpha(1f).withEndAction {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
            }
        }
        }
    }
}