package com.android.shopping.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.shopping.data.repository.auth.AuthRepository
import com.android.shopping.data.repository.cart.CartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel@Inject constructor( private val authRepository: AuthRepository) : ViewModel() {


    fun register(email: String, password: String){
        viewModelScope.launch {
            try {
             val result = authRepository.register(email, password )

             } catch (e: Exception){

             }

        }
    }

}