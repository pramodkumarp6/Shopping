package com.android.shopping.repositories

import com.android.shopping.data.ApiService
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject


@ViewModelScoped
class LoginRepository @Inject constructor( private val apiService: ApiService) {

    fun loginUser(email: String, password: String){
        CoroutineScope(Dispatchers.IO).launch {
            try {

            }catch (e: Exception){

                e.printStackTrace()   }

        }

    }
}