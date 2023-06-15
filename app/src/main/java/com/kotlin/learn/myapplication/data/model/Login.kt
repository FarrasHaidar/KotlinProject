package com.kotlin.learn.myapplication.data.model

import com.google.gson.annotations.SerializedName

data class Login(
    @field:SerializedName("user")
    val user:User,

    @field:SerializedName("token")
    val token: String,

    @field:SerializedName("loginResult")
    val loginResult: User,

)
