package com.smd.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationSet
import com.google.firebase.auth.FirebaseAuth
import android.view.animation.AnimationUtils
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //supportActionBar?.hide()

        firebaseAuth = FirebaseAuth.getInstance()

        Handler().postDelayed({
            checkUserAndNavigate()
        }, 3000)
    }

    private fun checkUserAndNavigate() {
        val currentUser = firebaseAuth.currentUser
        val intent = if (currentUser != null) {
            Intent(this, MonthlyOverview::class.java)
        } else {
            Intent(this, LoginPg::class.java)
        }
        startActivity(intent)
        finish()
    }
}
