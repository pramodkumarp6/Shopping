package com.android.shopping.domain.repository

interface AuthRepository {

    suspend fun login(email:String, password: String)

    suspend fun register(email:String, password: String)

    suspend fun forget(email:String)
}