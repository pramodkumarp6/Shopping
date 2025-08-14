package com.android.shopping.repositories

import com.android.shopping.data.ApiService
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@ViewModelScoped
class RegisterRepository@Inject constructor( private val apiService: ApiService) {

    fun userRegister(email: String, password: String){
        CoroutineScope(Dispatchers.IO).launch {
            try {

            }catch (e: Exception){

                e.printStackTrace()   }

        }

    }

}