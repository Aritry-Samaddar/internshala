package com.example.internshalaass1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {
    lateinit var prsnName: EditText
    lateinit var prsnEmail: EditText
    lateinit var prsnMobo: EditText
    lateinit var prsnAddress: EditText
    lateinit var prsnMainPass: EditText
    lateinit var prsnCfrmPass: EditText
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        sharedPreferences = getSharedPreferences(getString(R.string.shared_preferences), Context.MODE_PRIVATE)

        val emailId = sharedPreferences.getString("email", null)
        val phone = sharedPreferences.getString("number", null)


        title = "Register Yourself"

        prsnName = findViewById(R.id.txtName)
        prsnEmail = findViewById(R.id.txtEmail)
        prsnMobo = findViewById(R.id.txtMobNum)
        prsnAddress = findViewById(R.id.txtAddress)
        prsnMainPass = findViewById(R.id.txtMainPassword)
        prsnCfrmPass = findViewById(R.id.txtConfirmPassword)

        regstrBtn.setOnClickListener{
            val first = prsnName.text.toString()
            val second = prsnEmail.text.toString()
            val third = prsnMobo.text.toString()
            val fourth = prsnAddress.text.toString()
            val fifth = prsnMainPass.text.toString()
            val sixth = prsnCfrmPass.text.toString()
            val intentss = Intent(this, MainActivity::class.java)
            if(fifth != sixth || first == null || second == null || third == null || fourth == null ||
                fifth == null || sixth == null) {
                Toast.makeText(this, "Enter correct credentials!!", Toast.LENGTH_LONG).show()
            } else if(emailId == second || phone == third) {
                Toast.makeText(this, "This email id or phone number is already registered!!",
                    Toast.LENGTH_LONG).show()
            } else {
                sharedPreferences.edit().putString("username", first).apply()
                sharedPreferences.edit().putString("email", second).apply()
                sharedPreferences.edit().putString("number", third).apply()
                sharedPreferences.edit().putString("address", fourth).apply()
                sharedPreferences.edit().putString("password", fifth).apply()
                savedPreferences()
                intentss.putExtra("Name", first)
                intentss.putExtra("Email", second)
                intentss.putExtra("Phone Number", third)
                intentss.putExtra("Address", fourth)
                intentss.putExtra("PassWord", fifth)
                startActivity(intentss)
                finish()
            }
        }
    }
    fun savedPreferences() {
        sharedPreferences.edit().putBoolean("isRegistered", true).apply()
    }
}