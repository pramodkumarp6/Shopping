package com.android.shopping.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.shopping.data.repository.PaymentRepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class SplashViewModel @Inject constructor(private val paymentRepositoryImp: PaymentRepositoryImp): ViewModel() {


    fun splash(){
        viewModelScope.launch {
            try {


            } catch (e: Exception){

            }

        }
    }
}