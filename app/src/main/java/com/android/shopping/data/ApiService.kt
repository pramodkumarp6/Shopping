package com.android.shopping.data

import com.android.shopping.model.DefaultResponse
import com.android.shopping.model.LoginResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("register")
    suspend  fun createUser(
        @Field("email")email:String,
        @Field("password")password:String,
        @Field("name")name:String,
        @Field("gender")gender:String
    ): DefaultResponse


    @FormUrlEncoded
    @POST("login")
    fun login(@Field("email")email:String,
              @Field("password")password: String


    ): LoginResponse
}