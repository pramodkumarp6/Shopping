package com.android.shopping.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.shopping.data.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val authRepository: AuthRepository) :
    ViewModel() {


    fun loginUser(email: String, password: String) {
        viewModelScope.launch {
            try {
                val result = authRepository.loginUser(email, password)
            } catch (e: Exception) {

            }
        }
    }


}