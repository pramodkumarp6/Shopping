package com.android.shopping

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.android.shopping.viewmodels.ForgetViewModel
import com.android.shopping.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue


@AndroidEntryPoint
class ResetPassword : AppCompatActivity() {
    private val forgetViewModel: ForgetViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        title="Forget Password"

       // val email = editemail.text.toString().trim()


    }
}