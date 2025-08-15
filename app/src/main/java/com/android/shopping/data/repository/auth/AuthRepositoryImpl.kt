package com.android.shopping.data.repository.auth

import com.android.shopping.data.remote.AuthService
import com.android.shopping.domain.repository.AuthRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(private val authService: AuthService): AuthRepository {
    override suspend fun login(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun register(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun forget(email: String) {
        TODO("Not yet implemented")
    }


}