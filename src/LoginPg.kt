package com.smd.project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class LoginPg : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_pg)

        firebaseAuth = FirebaseAuth.getInstance()

        var forgotbtn = findViewById<Button>(R.id.forgotpwd_btn)
        forgotbtn.setOnClickListener {
//            startActivity(
//                Intent(this, ForgotPwd::class.java)
//            );
        }

        var signup = findViewById<LinearLayout>(R.id.signup_btn)
        signup.setOnClickListener{
            startActivity(Intent(this, SignUp::class.java))
        }

        var loginBtn = findViewById<Button>(R.id.login_btn)
        var email = findViewById<EditText>(R.id.email_edittxt)
        var pwd = findViewById<EditText>(R.id.pwd_edittxt)
        loginBtn.setOnClickListener{
            val email = email.text.toString()
            val pwd = pwd.text.toString()

            //validation of fields
            if (email.isNotEmpty() && pwd.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener{
                    if (it.isSuccessful){
                        val intent = Intent(this, TodayView::class.java)
                        startActivity(intent)
                    }
                    else {
                        Toast.makeText(this, "Failed to sign in", Toast.LENGTH_SHORT)
                    }
                }
            }
            else
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT)
        }
    }
}