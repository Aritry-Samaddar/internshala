package com.example.internshalaass1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.method.LinkMovementMethod
import android.text.style.UnderlineSpan
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.internshalaass1.databinding.ActivityLoginBinding
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var mobo: EditText
    lateinit var password: EditText
    lateinit var sharedPreferences: SharedPreferences
    lateinit var sharedPreferences2: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(getString(R.string.Shared_Preferences), Context.MODE_PRIVATE)
        sharedPreferences2 = getSharedPreferences(getString(R.string.shared_preferences), Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)
        val isRegistered = sharedPreferences2.getBoolean("isRegistered", false)
        val phone = sharedPreferences2.getString("number", null)
        val passwords = sharedPreferences2.getString("password", null)
        val emailId = sharedPreferences2.getString("email", null)
        val username = sharedPreferences2.getString("username", null)
        val address = sharedPreferences2.getString("address", null)
        
        setContentView(R.layout.activity_login)

        textSpan()

        if(isLoggedIn) {
            val mainIntent = Intent(this, MainActivity::class.java)
            mainIntent.putExtra("Name", username)
            mainIntent.putExtra("Email", emailId)
            mainIntent.putExtra("Phone Number", phone)
            mainIntent.putExtra("Address", address)
            mainIntent.putExtra("PassWord", passwords)
            startActivity(mainIntent)
            finish()
        }

        mobo = findViewById(R.id.txtPhNum)
        password = findViewById(R.id.txtPassword)

        title = "LogIn"

        btnLogin.setOnClickListener {
            val mobileNumber = mobo.text.toString()
            val mobPassword = password.text.toString()
            var intents = Intent(this, MainActivity::class.java)

            if(mobileNumber == phone && mobPassword == passwords) {
                savedPreferences()
                intents.putExtra("Name", username)
                intents.putExtra("Email", emailId)
                intents.putExtra("Phone Number", phone)
                intents.putExtra("Address", address)
                intents.putExtra("PassWord", passwords)
                startActivity(intents)
                finish()
            } else {
                Toast.makeText(
                    this, "Enter correct credentials!!", Toast.LENGTH_LONG
                ).show()
            }
        }

        txtRegister.setOnClickListener{
            val intentRgstr = Intent(this, RegistrationActivity::class.java)
            startActivity(intentRgstr)
            finish()
        }

        txtForgot.setOnClickListener{
            val intentForgot = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intentForgot)
            finish()
        }
    }

    fun savedPreferences() {
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
    }
    fun textSpan() {
        val spannableStringForgot = SpannableString("Forgot Password?")
        val spannableStringRegister = SpannableString("Don't have an account? Sign up now")
        val underLine = UnderlineSpan()
        spannableStringForgot.setSpan(underLine, 0, spannableStringForgot.length, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        spannableStringRegister.setSpan(underLine, 0, spannableStringRegister.length, Spannable.SPAN_INCLUSIVE_EXCLUSIVE)
        txtForgot.text = spannableStringForgot
        txtRegister.text = spannableStringRegister
    }

}