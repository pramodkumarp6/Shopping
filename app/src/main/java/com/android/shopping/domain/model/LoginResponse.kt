package com.android.shopping.domain.model

data class LoginResponse(val error: Boolean,val message: String, val user: User)