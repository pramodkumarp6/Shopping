package com.android.shopping.di

import com.android.shopping.data.remote.AuthService
import com.android.shopping.utils.Urls
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetWorkModule {
   // private val AuthRepository = "Basic " + Base64.encodeToString("user:123456".toByteArray(), Base64.NO_WRAP)
   //private val AUTH = "Basic "+ Base64.encodeToString("belalkhan:123456".toByteArray(), Base64.NO_WRAP)
   @Singleton
   @Provides
   fun provideOkHttpClient(): OkHttpClient {
       return OkHttpClient.Builder()
           // .addInterceptor(AuthInterceptor()) // optional
           .build()
   }
   /* private val okHttpClient =OkHttpClient.Builder()
        .addInterceptor{chain ->
            val original =chain.request()
            val requestBuilder = original.newBuilder()
                .addHeader("Authentication", AuthRepository)

                .method(original.method(), original.body())
            val request = requestBuilder.build()
            chain.proceed(request)


        }.build()
*/
   @Singleton
   @Provides
   fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
       return Retrofit.Builder()
           .baseUrl(Urls.BASE_URl)
           .addConverterFactory(MoshiConverterFactory.create())
           .build()
   }
    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }
}