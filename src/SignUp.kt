package com.smd.project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_pg)

        firebaseAuth = FirebaseAuth.getInstance()

        var login = findViewById<LinearLayout>(R.id.login_btn)
        login.setOnClickListener { finish() }

        var signup = findViewById<Button>(R.id.signup_btn)
        var name = findViewById<EditText>(R.id.name_edittxt)
        var email = findViewById<EditText>(R.id.email_edittxt)
        var pwd = findViewById<EditText>(R.id.pwd_edittxt)
        var phone = findViewById<EditText>(R.id.phone_edittxt)
        var address = findViewById<EditText>(R.id.address_edittxt)
        signup.setOnClickListener {
            val name = name.text.toString()
            val email = email.text.toString()
            val pwd = pwd.text.toString()
            val phone = phone.text.toString()
            val address = address.text.toString()

            // Validation of fields
            if (name.isNotEmpty() && email.isNotEmpty() && pwd.isNotEmpty() && phone.isNotEmpty() && address.isNotEmpty()) {
                firebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user = firebaseAuth.currentUser
                        val userId = user?.uid
                        val database = FirebaseDatabase.getInstance().reference.child("Users")
                        userId?.let {
                            val userData = HashMap<String, Any>()
                            userData["name"] = name
                            userData["email"] = email
                            userData["phone"] = phone
                            userData["address"] = address
                            database.child(it).setValue(userData).addOnSuccessListener {
                                Toast.makeText(this, "Successfully signed up", Toast.LENGTH_SHORT).show()
                                startActivity(Intent(this, MonthlyOverview::class.java))
                                finish() // Finish the current activity
                            }.addOnFailureListener { e ->
                                Toast.makeText(this, "Failed to save user data: ${e.message}", Toast.LENGTH_SHORT).show()
                            }
                        }
                    } else {
                        Toast.makeText(this, "Failed to sign up", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}