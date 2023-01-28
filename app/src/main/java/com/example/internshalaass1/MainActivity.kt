package com.example.internshalaass1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.internshalaass1.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Welcome"

        var strPhone = intent.getStringExtra("Phone Number")
        var strPassword = intent.getStringExtra("PassWord")
        var strName = intent.getStringExtra("Name")
        var strEmail = intent.getStringExtra("Email")
        var strAddress = intent.getStringExtra("Address")

        val txt: TextView = findViewById(R.id.textTWO)
        txt.setOnClickListener{
            txt.setText("Name : " + strName + ", " + "Email : " + strEmail + ", " + "Address : "
                    + strAddress + ", " + "Phone Number : " + strPhone + ", " + "Password : "
                    + strPassword)
        }
    }
}