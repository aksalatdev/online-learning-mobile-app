package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        btn_signin.setOnClickListener {
            val email = tv_email.text.toString().trim()
            val password = tv_password.text.toString().trim()

            if (email.isEmpty()) {
                tv_email.error = "Email Harus diisi"
                tv_email.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                tv_email.error = "Email tidak valid"
                tv_email.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty() || password.length < 6){
                tv_password.error = "Password harus lebih dari 6 karakter"
                tv_password.requestFocus()
                return@setOnClickListener
            }

            loginUser(email, password)
        }

        btn_signup.setOnClickListener{
            Intent(this@MainActivity, signup::class.java).also {
                startActivity(it)
            }

        }
    }

    private fun loginUser(email: String, password: String) {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this){
                    if (it.isSuccessful){
                        Intent(this@MainActivity, home::class.java).also{intent ->
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                            startActivity(intent)
                        }
                    }else{
                        Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
    }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null)
            Intent(this@MainActivity, home::class.java).also{intent ->
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
    }

}