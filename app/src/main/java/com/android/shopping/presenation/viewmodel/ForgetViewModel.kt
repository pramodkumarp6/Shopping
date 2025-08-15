package com.android.shopping.presenation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.shopping.domain.repository.AuthRepository
import com.android.shopping.domain.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgetViewModel @Inject constructor( private val authRepository: AuthRepository) : ViewModel(){

    fun userForget(email: String){
        viewModelScope.launch {
            try {

            val result = authRepository.forget(email)
            } catch (e: Exception){

            }

        }
    }

}