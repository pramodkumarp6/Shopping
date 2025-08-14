package com.android.shopping.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.shopping.repositories.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val loginRepository: LoginRepository) :
    ViewModel() {


    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            try {
                val result = loginRepository.loginUser(email, password)
            } catch (e: Exception) {

            }
        }
    }


}