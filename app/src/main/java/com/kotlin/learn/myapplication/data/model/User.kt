package com.kotlin.learn.myapplication.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("userId")
    val userId: String,

    @field:SerializedName("token")
    val token: String,

    @field:SerializedName("recommendation")
    val recommendation: String
)
