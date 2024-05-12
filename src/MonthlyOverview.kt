package com.smd.project

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference

class MonthlyOverview : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.monthly_overview)

        val backBtn = findViewById<ImageButton>(R.id.back)
        backBtn.setOnClickListener { finish() }

        // ------ BOTTOM NAV BAR ------
        val team_btn = findViewById<ImageButton>(R.id.team_btn)
        team_btn.setOnClickListener {
            startActivity(Intent(this, TeamsPg::class.java))
        }
        val notif_btn = findViewById<ImageButton>(R.id.notif_btn)
        notif_btn.setOnClickListener {
            startActivity(Intent(this, Notifs::class.java))
        }
        val profile_btn = findViewById<ImageButton>(R.id.profile_btn)
        profile_btn.setOnClickListener {
            startActivity(Intent(this, MyProfile::class.java))
        }
    }
}