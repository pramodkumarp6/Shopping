package com.android.shopping.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.shopping.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgetViewModel @Inject constructor( private val forgetUseRepository: ProductRepository) : ViewModel(){

    fun userForget(email: String){
        viewModelScope.launch {
            try {

            val result = forgetUseRepository.userFoget(email)
            } catch (e: Exception){

            }

        }
    }

}