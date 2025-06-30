package com.android.simple

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.simple.app.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.android.simple.model.DefaultResponse
import com.android.simple.model.LoginResponse

import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.editTextPassword
import okhttp3.ResponseBody


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        title="Login"


        buttonLogin.setOnClickListener{

            val progressDialog = ProgressDialog(this@LoginActivity)
            val email = editemail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()
                    if(email.isEmpty()){
                        editemail.error="Required Email"
                        editemail.requestFocus()
                        return@setOnClickListener

                    }

            if(password.isEmpty()){
                editTextPassword.error="Required Pasword"
                editTextPassword.requestFocus()
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




           textViewRegister2.setOnClickListener {
               startActivity(Intent(this@LoginActivity, MainActivity::class.java))
           }

               textViewRegister1.setOnClickListener {
                   startActivity(Intent(this@LoginActivity,ResetPassword::class.java))
               }


        }

    }








