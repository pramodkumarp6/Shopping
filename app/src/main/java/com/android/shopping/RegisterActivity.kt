package com.android.shopping

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.android.shopping.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        title = "Registration"

        mainBinding.buttonSignUp.setOnClickListener {

            val progressDialog = ProgressDialog(this@RegisterActivity)
            val email = mainBinding.editTextEmail.text.toString().trim()
            val password = mainBinding.editTextPassword.toString().trim()
            val name = mainBinding.editTextName.text.toString().trim()
            val gender = mainBinding.editTextSchool.text.toString().trim()

            if (email.isEmpty()) {
                mainBinding.editTextEmail.error = "email is Requied"
                mainBinding.editTextEmail.requestFocus()
                return@setOnClickListener

            }

            if (password.isEmpty()) {
                mainBinding.editTextPassword.error = "Password is Required"
                mainBinding.editTextPassword.requestFocus()
                return@setOnClickListener
            }

            if (name.isEmpty()) {
                mainBinding.editTextName.error = "Name is Reqiued "
                mainBinding.editTextName.requestFocus()
                return@setOnClickListener
            }

            if (gender.isEmpty()) {
                mainBinding.editTextSchool.error = "School is Required"
                mainBinding.editTextSchool.requestFocus()
                return@setOnClickListener


            }
            progressDialog.setTitle("Kotlin Progress Bar")
            progressDialog.setMessage("Application is loading, please wait")
            progressDialog.show()


            lifecycleScope.launch {
                try {


                } catch (e: Exception) {

                }
            }
        }
    }
}























