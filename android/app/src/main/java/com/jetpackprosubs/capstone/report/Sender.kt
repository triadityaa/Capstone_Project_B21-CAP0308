package com.jetpackprosubs.capstone.report

import com.jetpackprosubs.capstone.data.Message
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Sender {
    @POST("webhook")
    fun messageSender(@Body userMessage:Message): Call<ArrayList<BotResponse>>
}