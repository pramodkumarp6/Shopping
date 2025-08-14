package com.android.shopping.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.shopping.repositories.RegisterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel@Inject constructor( private val registerRepository: RegisterRepository) : ViewModel() {


    fun register(email: String, password: String){
        viewModelScope.launch {
            try {
             val result = registerRepository.userRegister(email, password )

             } catch (e: Exception){

             }

        }
    }

}