package com.kotlin.learn.myapplication.data.model

import com.google.gson.annotations.SerializedName

data class Register(
    @field:SerializedName("error")
    val error: Boolean,

    @field:SerializedName("message")
    val message: String

)
