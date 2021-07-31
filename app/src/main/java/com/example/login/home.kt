package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

class home : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        auth = FirebaseAuth.getInstance()

        materibtn.setOnClickListener {
            val intent = Intent(this@home, materi::class.java)
            startActivity(intent)
        }

        gurumenu.setOnClickListener {
            val intent = Intent(this@home, daftarguru::class.java)
            startActivity(intent)
        }



        btn_logout.setOnClickListener{
            auth.signOut()
            Intent(this@home, MainActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }

    }
}