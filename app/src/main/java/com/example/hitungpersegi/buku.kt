package com.example.hitungpersegi

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class buku (
    val judul : String?,
    val pengarang :String?,
    val halaman : Int?
        ):Parcelable