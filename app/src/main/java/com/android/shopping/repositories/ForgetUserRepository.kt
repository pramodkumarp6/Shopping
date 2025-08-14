package com.android.shopping.repositories

import com.android.shopping.data.ApiService
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject
@ViewModelScoped
class ForgetUserRepository@Inject constructor( private val apiService: ApiService) {

    fun userFoget(email: String){

    }
}