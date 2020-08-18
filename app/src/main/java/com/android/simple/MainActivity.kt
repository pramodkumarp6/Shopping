package com.android.simple

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.simple.app.RetrofitClient
import com.android.simple.model.DefaultResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title= "Registration"

        buttonSignUp.setOnClickListener {

            val progressDialog = ProgressDialog(this@MainActivity)
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.toString().trim()
            val name = editTextName.text.toString().trim()
            val gender = editTextSchool.text.toString().trim()

            if (email.isEmpty()) {
                editTextEmail.error = "email is Requied"
                editTextEmail.requestFocus()
                return@setOnClickListener

            }

            if (password.isEmpty()) {
                editTextPassword.error = "Password is Required"
                editTextPassword.requestFocus()
                return@setOnClickListener
            }

            if (name.isEmpty()) {
                editTextName.error = "Name is Reqiued "
                editTextName.requestFocus()
                return@setOnClickListener
            }

            if (gender.isEmpty()) {
                editTextSchool.error = "School is Required"
                editTextSchool.requestFocus()
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



