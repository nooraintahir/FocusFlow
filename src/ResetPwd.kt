package com.smd.project

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ResetPwd : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reset_pwd)

        val reset_btn = findViewById<Button>(R.id.reset_btn)
        reset_btn.setOnClickListener{
            val pwd = findViewById<EditText>(R.id.pwd_edittxt).text.toString()
            val reenter_pwd = findViewById<EditText>(R.id.pwd_reenter_edittxt).text.toString()

            if(pwd.isNotEmpty() && reenter_pwd.isNotEmpty())
            {
                if (pwd != reenter_pwd){
                    Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            }
            finish()
        }
    }
}