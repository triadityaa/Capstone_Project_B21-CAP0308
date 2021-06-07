package com.jetpackprosubs.capstone.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jetpackprosubs.capstone.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailDataViewModel::class.java]
        val provinsi = viewModel.getProvinsi()

        val provinsiAdapter = DetailAdapter()
        provinsiAdapter.setMovie(provinsi)

        binding.rvProvinsi.layoutManager = LinearLayoutManager(this)
        binding.rvProvinsi.setHasFixedSize(true)
        binding.rvProvinsi.adapter = provinsiAdapter
    }
}