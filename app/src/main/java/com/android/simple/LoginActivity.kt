package com.android.simple

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.simple.app.RetrofitClient
import com.android.simple.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.android.simple.model.LoginResponse





class LoginActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityLoginBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title="Login"


        binding. buttonLogin.setOnClickListener{

            val progressDialog = ProgressDialog(this@LoginActivity)
            val email = binding.editemail.text.toString().trim()
            val password = binding.editTextPassword.text.toString().trim()
                    if(email.isEmpty()){
                        binding. editemail.error="Required Email"
                        binding.editemail.requestFocus()
                        return@setOnClickListener

                    }

            if(password.isEmpty()){
                binding.editTextPassword.error="Required Pasword"
                binding.editTextPassword.requestFocus()
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




        binding. textViewRegister2.setOnClickListener {
               startActivity(Intent(this@LoginActivity, MainActivity::class.java))
           }

        binding. textViewRegister1.setOnClickListener {
                   startActivity(Intent(this@LoginActivity,ResetPassword::class.java))
               }


        }

    }








