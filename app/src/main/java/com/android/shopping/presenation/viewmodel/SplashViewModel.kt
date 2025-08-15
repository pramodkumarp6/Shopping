package com.android.shopping.presenation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.shopping.domain.repository.AuthRepository
import com.android.shopping.data.repository.payment.PaymentRepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class SplashViewModel @Inject constructor(private val authRepository: AuthRepository): ViewModel() {


    fun splash(){
        viewModelScope.launch {
            try {


            } catch (e: Exception){

            }

        }
    }
}