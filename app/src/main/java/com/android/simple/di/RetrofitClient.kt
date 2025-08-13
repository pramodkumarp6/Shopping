package com.android.simple.di

import com.android.simple.utils.Urls
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitClient {
   // private val Auth = "Basic " + Base64.encodeToString("user:123456".toByteArray(), Base64.NO_WRAP)
   //private val AUTH = "Basic "+ Base64.encodeToString("belalkhan:123456".toByteArray(), Base64.NO_WRAP)
    public const val  BASE_URl="http://192.168.1.100/retrofit/public/"
   /* private val okHttpClient =OkHttpClient.Builder()
        .addInterceptor{chain ->
            val original =chain.request()
            val requestBuilder = original.newBuilder()
                .addHeader("Authentication", Auth)

                .method(original.method(), original.body())
            val request = requestBuilder.build()
            chain.proceed(request)


        }.build()
*/
   @Singleton
   @Provides
   fun provideRetrofit(): Retrofit {
       return Retrofit.Builder()
           .baseUrl(Urls.BASE_URl)
           .addConverterFactory(MoshiConverterFactory.create())
           .build()
   }
    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}