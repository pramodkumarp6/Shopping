package com.android.shopping.presenation.ui.auth

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.android.shopping.R
import com.android.shopping.presenation.viewmodel.ForgetViewModel
import dagger.hilt.android.AndroidEntryPoint

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