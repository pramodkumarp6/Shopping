package com.android.simple.viewmodels

import com.android.simple.repositories.SplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject



//@HiltViewModel
class SplashViewModel @Inject constructor(private val splashRepository: SplashRepository) {
}