package com.android.shopping

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.android.shopping.databinding.ActivityLoginBinding
import com.android.shopping.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var loginbinding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginbinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginbinding.root)

        title = "Login"

        loginbinding.textViewRegister2.setOnClickListener {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }

        loginbinding.textViewRegister1.setOnClickListener {
            startActivity(Intent(this@LoginActivity,ResetPassword::class.java))
        }


        loginbinding.buttonLogin.setOnClickListener {

            loginUser()

            val progressDialog = ProgressDialog(this@LoginActivity)








            progressDialog.setTitle("Login..")
            progressDialog.setMessage("loding")
            progressDialog.show()


            lifecycleScope.launch {

            }


        }}

    private fun loginUser() {
        val email = loginbinding.editemail.text.toString().trim()
        val password = loginbinding.editTextPassword.text.toString().trim()

        viewModel.login(email,password)
    }

}









