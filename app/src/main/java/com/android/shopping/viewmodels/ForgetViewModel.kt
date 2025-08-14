package com.android.shopping.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.shopping.repositories.ForgetUserRepository
import com.android.shopping.repositories.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ForgetViewModel @Inject constructor( private val forgetUseRepository: ForgetUserRepository) : ViewModel(){

    fun userForget(email: String){
        viewModelScope.launch {
            try {

            val result = forgetUseRepository.userFoget(email)
            } catch (e: Exception){

            }

        }
    }

}