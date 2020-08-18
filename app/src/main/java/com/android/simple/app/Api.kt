package com.android.simple.app


import com.android.simple.model.DefaultResponse
import com.android.simple.model.LoginResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import kotlin.random.Random

interface Api {
    @FormUrlEncoded
    @POST("register")
    fun createUser(
        @Field("email")email:String,
        @Field("password")password:String,
        @Field("name")name:String,
        @Field("gender")gender:String
    ):Call<DefaultResponse>


    @FormUrlEncoded
    @POST("login")
    fun login(@Field("email")email:String,
              @Field("password")password: String


    ):Call<LoginResponse>
}