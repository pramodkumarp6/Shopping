package com.android.shopping.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.shopping.repositories.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(loginRepository: LoginRepository) : ViewModel(){


    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {

            }catch (e: Exception){

            }
        }
    }




}