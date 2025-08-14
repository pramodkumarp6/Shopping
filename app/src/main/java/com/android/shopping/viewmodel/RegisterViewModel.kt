package com.android.shopping.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.shopping.data.repository.CartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel@Inject constructor( private val cartRepository: CartRepository) : ViewModel() {


    fun register(email: String, password: String){
        viewModelScope.launch {
            try {
             val result = cartRepository.userRegister(email, password )

             } catch (e: Exception){

             }

        }
    }

}