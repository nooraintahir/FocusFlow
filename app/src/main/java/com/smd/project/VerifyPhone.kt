package com.smd.project

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class VerifyPhone : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.verify_phone)

        val verify_btn = findViewById<Button>(R.id.verify_btn)
        verify_btn.setOnClickListener{
            finish()
        }

        val resend = findViewById<LinearLayout>(R.id.resend_btn)
        resend.setOnClickListener{
            finish()
        }
    }
}