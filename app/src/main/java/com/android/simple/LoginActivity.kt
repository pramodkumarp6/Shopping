package com.android.simple

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.simple.di.RetrofitClient
import com.android.simple.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.android.simple.model.LoginResponse




class LoginActivity : AppCompatActivity() {
    private lateinit var loginbinding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginbinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginbinding.root)
        title="Login"


        loginbinding.buttonLogin.setOnClickListener{

            val progressDialog = ProgressDialog(this@LoginActivity)
            val email = loginbinding.editemail.text.toString().trim()
            val password = loginbinding.editTextPassword.text.toString().trim()
                    if(email.isEmpty()){
                        loginbinding.editemail.error="Required Email"
                        loginbinding.editemail.requestFocus()
                        return@setOnClickListener

                    }

            if(password.isEmpty()){
                loginbinding.editTextPassword.error="Required Pasword"
                loginbinding.editTextPassword.requestFocus()
                return@setOnClickListener
            }
            progressDialog.setTitle("Login..")
            progressDialog.setMessage("loding")
            progressDialog.show()

             RetrofitClient.instance.login(email,password)
                 .enqueue(object :Callback<LoginResponse>{
                     override fun onFailure(call: Call<LoginResponse>, t: Throwable) {


                     }

                     override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                         progressDialog.hide()
                         //Toast.makeText(applicationContext,response.body()?.message ,Toast.LENGTH_LONG).show();

                         if(!response.body()?.error!!){
                             val intent = Intent(applicationContext,ProfileActivity::class.java)
                             intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                           startActivity(intent)

                         }else{
                             Toast.makeText(applicationContext,response.body()?.message ,Toast.LENGTH_LONG).show();
                         }

                     }

                 })




        }




        loginbinding.textViewRegister2.setOnClickListener {
               startActivity(Intent(this@LoginActivity, MainActivity::class.java))
           }

        loginbinding.textViewRegister1.setOnClickListener {
                   startActivity(Intent(this@LoginActivity,ResetPassword::class.java))
               }


        }

    }








