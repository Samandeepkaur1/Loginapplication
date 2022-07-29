package com.saman.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class OtpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var email: String = ""
        lateinit var tvMail: TextView
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)
        intent?.let { abc->
            if(abc.hasExtra("email"))
                email = abc.getStringExtra("email") as String
        }?:kotlin.run {  }

        tvMail = findViewById(R.id.tvMail)
        tvMail.setText(email)
    }
}