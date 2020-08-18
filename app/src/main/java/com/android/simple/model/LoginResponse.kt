package com.android.simple.model

import android.webkit.ConsoleMessage

data class LoginResponse(val error: Boolean,val message: String, val user: User)