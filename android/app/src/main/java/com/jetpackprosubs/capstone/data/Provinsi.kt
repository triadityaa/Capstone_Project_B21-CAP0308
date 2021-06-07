package com.jetpackprosubs.capstone.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class Provinsi(
    var nama: String,
    var total: Int,
    var perempuan: Int,
    var anak: Int)
