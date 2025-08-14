package com.android.shopping.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.shopping.repositories.SplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class SplashViewModel @Inject constructor(private val splashRepository: SplashRepository): ViewModel() {


    fun splash(){
        viewModelScope.launch {
            try {


            } catch (e: Exception){

            }

        }
    }
}