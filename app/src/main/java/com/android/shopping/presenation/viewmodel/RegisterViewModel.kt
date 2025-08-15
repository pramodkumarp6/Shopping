package com.android.shopping.presenation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.shopping.domain.repository.AuthRepository
import com.android.shopping.domain.repository.CartRepository
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