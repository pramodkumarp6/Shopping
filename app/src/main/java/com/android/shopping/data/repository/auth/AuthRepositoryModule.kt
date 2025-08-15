package com.android.shopping.data.repository.auth

import com.android.shopping.domain.repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class AuthRepositoryModule {
    @Binds
    @Singleton
    abstract  fun bindAuthRepository(impl:AuthRepositoryImpl): AuthRepository
}