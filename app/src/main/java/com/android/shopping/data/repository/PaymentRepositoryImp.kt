package com.android.shopping.data.repository

import com.android.shopping.data.remote.AuthService
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@ViewModelScoped
class PaymentRepositoryImp@Inject constructor(private val authService: AuthService) {

    fun spash(email: String, password: String){
        CoroutineScope(Dispatchers.IO).launch {
            try {

            }catch (e: Exception){

                e.printStackTrace()   }

        }

    }
}