package com.smd.project

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class ForgotPwd : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forgot_pwd)

        val reset_btn = findViewById<Button>(R.id.reset_btn)
        reset_btn.setOnClickListener{
            finish()
        }

        val resend = findViewById<LinearLayout>(R.id.resend_btn)
        resend.setOnClickListener{
            finish()
        }
    }
}