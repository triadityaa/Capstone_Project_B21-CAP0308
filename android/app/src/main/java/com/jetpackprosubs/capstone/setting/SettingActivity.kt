package com.jetpackprosubs.capstone.setting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import com.jetpackprosubs.capstone.R
import com.jetpackprosubs.capstone.databinding.ActivitySettingBinding

private lateinit var binding: ActivitySettingBinding

class SettingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = getString(R.string.settings)

        binding.languange.setOnClickListener {
            val bahasa = Intent(Settings.ACTION_LOCALE_SETTINGS)
            startActivity(bahasa)
        }
    }
}