package com.jetpackprosubs.capstone.detail

import androidx.lifecycle.ViewModel
import com.jetpackprosubs.capstone.data.Provinsi
import com.jetpackprosubs.capstone.utils.DummyFile

class DetailDataViewModel: ViewModel() {
    fun getProvinsi(): List<Provinsi> = DummyFile.dummyProv()
}