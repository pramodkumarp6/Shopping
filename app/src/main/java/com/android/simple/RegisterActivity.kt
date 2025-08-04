package com.android.simple

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.simple.di.RetrofitClient
import com.android.simple.databinding.ActivityMainBinding
import com.android.simple.model.DefaultResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        title= "Registration"

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

            RetrofitClient.instance.createUser(email, password, name, gender)

                .enqueue(object: Callback<DefaultResponse> {

                    override fun onFailure(call: Call<DefaultResponse>, t: Throwable) {

                        Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<DefaultResponse>, response: Response<DefaultResponse>) {
                        progressDialog.hide()
                        Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_LONG).show()
                    }

                })


    }
}


}



