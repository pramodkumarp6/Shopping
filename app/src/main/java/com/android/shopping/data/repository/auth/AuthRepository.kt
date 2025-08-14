package com.android.shopping.data.repository.auth

interface AuthRepository {

    suspend fun login(email:String, password: String)

    suspend fun register(email:String, password: String)

    suspend fun forget(email:String)
}