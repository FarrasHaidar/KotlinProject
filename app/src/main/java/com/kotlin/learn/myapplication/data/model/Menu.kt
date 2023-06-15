package com.kotlin.learn.myapplication.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Menu(
    var gambarMenu: Int,
    var namaMenu: String,
    var hargaMenu: String
):Parcelable
