package com.smd.project

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TodayView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.today_view)
//        supportActionBar?.hide()

        val backBtn = findViewById<ImageButton>(R.id.back)
        backBtn.setOnClickListener { finish() }

        var menu_btn = findViewById<ImageButton>(R.id.menu_icon)
        menu_btn.setOnClickListener { showPopupMenu(menu_btn) }
    }
    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.tasks_menu, popupMenu.menu)

//        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
//            when (item.itemId) {
//                com.google.firebase.database.R.id.edit_profile -> {
//                    // Handle "Edit Profile" action
//                    startActivity(Intent(this, EditProfile::class.java))
//                    true
//                }
//                com.google.firebase.database.R.id.logout -> {
//                    // Handle "Logout" action
//                    logoutUser()
//                    true
//                }
//                else -> false
//            }
//        }
        popupMenu.show()
    }
}