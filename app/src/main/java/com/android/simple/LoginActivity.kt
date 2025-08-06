package com.android.simple

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.android.simple.di.RetrofitClient
import com.android.simple.databinding.ActivityLoginBinding
import kotlinx.coroutines.launch
import retrofit2.HttpException


class LoginActivity : AppCompatActivity() {
    private lateinit var loginbinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginbinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginbinding.root)
        title = "Login"


        loginbinding.buttonLogin.setOnClickListener {

            val progressDialog = ProgressDialog(this@LoginActivity)
            val email = loginbinding.editemail.text.toString().trim()
            val password = loginbinding.editTextPassword.text.toString().trim()
            if (email.isEmpty()) {
                loginbinding.editemail.error = "Required Email"
                loginbinding.editemail.requestFocus()
                return@setOnClickListener

            }

            if (password.isEmpty()) {
                loginbinding.editTextPassword.error = "Required Pasword"
                loginbinding.editTextPassword.requestFocus()
                return@setOnClickListener
            }
            progressDialog.setTitle("Login..")
            progressDialog.setMessage("loding")
            progressDialog.show()


            lifecycleScope.launch {

                try {
                    val response = RetrofitClient.instance.login(email, password)
                    if (!response.error!!) {
                        val intent = Intent(applicationContext, ProfileActivity::class.java)
                        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(intent)

                    } else {
                        Toast.makeText(this@LoginActivity, response.message, Toast.LENGTH_LONG)
                            .show();
                    }

                } catch (e: HttpException){
                    Toast.makeText(this@LoginActivity, "Network Error: ${e.message()}", Toast.LENGTH_LONG).show()


                } catch (e: Exception) {
                    Toast.makeText(this@LoginActivity, "Unexpected Error: ${e.localizedMessage}", Toast.LENGTH_LONG).show()

                }

            }








        }


        loginbinding.textViewRegister2.setOnClickListener {
               startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
           }

        loginbinding.textViewRegister1.setOnClickListener {
                   startActivity(Intent(this@LoginActivity,ResetPassword::class.java))
               }


        }

    }








