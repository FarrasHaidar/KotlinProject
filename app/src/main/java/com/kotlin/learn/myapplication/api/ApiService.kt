package com.kotlin.learn.myapplication.api

import com.kotlin.learn.myapplication.data.model.Login
import com.kotlin.learn.myapplication.data.model.Register
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    @FormUrlEncoded
    fun doLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<Login>

    @POST("register")
    @FormUrlEncoded
    fun doRegister(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<Register>
}