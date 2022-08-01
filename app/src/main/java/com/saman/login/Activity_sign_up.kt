package com.saman.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.*
import java.util.jar.Attributes

class Activity_sign_up : AppCompatActivity() {
    lateinit var etName: EditText
    lateinit var etEmail: EditText
    lateinit var etPassword: EditText
    lateinit var etRePassword: EditText
    lateinit var etPhone: EditText
    lateinit var rgGender: RadioGroup
    lateinit var rbShe: RadioButton
    lateinit var rbHe: RadioButton
    lateinit var rbOthers: RadioButton
    lateinit var etOthers: EditText
    lateinit var btnSignUp: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        etName = findViewById(R.id.etName)
        etOthers = findViewById(R.id.etOtherName)
        etEmail = findViewById(R.id.etEmail)
        etPhone = findViewById(R.id.etPhone_number)
        etPassword = findViewById(R.id.etPassword)
        etRePassword = findViewById(R.id.etPassword1)
        rbHe = findViewById(R.id.rbHe)
        rbShe = findViewById(R.id.rbShe)
        rbOthers = findViewById(R.id.rbOthers)
        rgGender = findViewById(R.id.rgGender)
        btnSignUp = findViewById(R.id.btnSignUp)

        btnSignUp.setOnClickListener {
    System.out.println("SIGNUP Clicked")

    var name = etName.text.toString()
    var email = etEmail.text.toString()
    var phone = etPhone.text.toString()
    var password = etPassword.text.toString()
    var conPass = etRePassword.text.toString()
    var others = etOthers.text.toString()

            rgGender.setOnCheckedChangeListener { radioGroup, id ->
                when(id){
                    R.id.rbOther->{
                        Toast.makeText(this, resources.getString(R.string.others), Toast.LENGTH_LONG).show()
                        etOthers.visibility = View.VISIBLE
                    }
                    else->{
                        etOthers.visibility = View.GONE
                    }
                }
            }
    System.out.println("name $name")
    if (name.isNullOrEmpty()) {
        etName.error = resources.getString(R.string.enter_your_name)
        etName.requestFocus()
    }
    else if (email.isNullOrEmpty() || (!Patterns.EMAIL_ADDRESS.matcher(email).matches())) {
        etEmail.error = resources.getString(R.string.please_enter_email)
        etEmail.requestFocus()

    }
    else if (phone.isNullOrEmpty() || (phone.length<10)) {
        etPhone.error = resources.getString(R.string.enter_your_Phonenumber)
        etPhone.requestFocus()
    }
    else if (password.isNullOrEmpty() ) {
        etPassword.error = resources.getString(R.string.enter_password)
        etPassword.requestFocus()
    }
    else if (conPass.isNullOrEmpty()) {
        etRePassword.error = resources.getString(R.string.Reenter_password)
        etRePassword.requestFocus()
    }
    else if (conPass != password){
        etRePassword.error = resources.getString(R.string.password_should_be_same)
        etRePassword.requestFocus()
    }
    else if ((etOthers.visibility == View.VISIBLE) && (others.isNullOrEmpty())) {
        etOthers.error = resources.getString(R.string.enter_other_name)
        etOthers.requestFocus()
    }

    else {
        Toast.makeText(
            this,
            resources.getString(R.string.SignUp_successfully),
            Toast.LENGTH_LONG
        ).show()
        finish()
    }
}
    }
}



