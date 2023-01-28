package com.example.internshalaass1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.internshalaass1.databinding.ActivityForgotPasswordBinding
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity : AppCompatActivity() {
    lateinit var frgtMobo: EditText
    lateinit var frgtEmail: EditText
    lateinit var sharedPreferences: SharedPreferences
    lateinit var sharedPreferences2: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        sharedPreferences = getSharedPreferences(getString(R.string.Shared_Preferences), Context.MODE_PRIVATE)
        sharedPreferences2 = getSharedPreferences(getString(R.string.shared_preferences), Context.MODE_PRIVATE)
        val phone = sharedPreferences2.getString("number", null)
        val passwords = sharedPreferences2.getString("password", null)
        val emailId = sharedPreferences2.getString("email", null)
        val username = sharedPreferences2.getString("username", null)
        val address = sharedPreferences2.getString("address", null)


        title = "Forgot Password"

        frgtMobo = findViewById(R.id.txtMobNumFrgt)
        frgtEmail = findViewById(R.id.txtEmailFrgt)

        nextBtn.setOnClickListener{
            val prsnFrgtMob = frgtMobo.text.toString()
            val prsnFrgtEmail = frgtEmail.text.toString()
            val intentsss = Intent(this, MainActivity::class.java)

            if(prsnFrgtMob == phone && prsnFrgtEmail == emailId) {
//                savedPreferences()
                intentsss.putExtra("Name", username)
                intentsss.putExtra("Email", emailId)
                intentsss.putExtra("Phone Number", phone)
                intentsss.putExtra("Address", address)
                intentsss.putExtra("PassWord", passwords)
                startActivity(intentsss)
                finish()
            } else {
                Toast.makeText(this, "Enter correct credentials!!", Toast.LENGTH_LONG).show()
            }
        }
    }
    fun savedPreferences() {
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
    }
}