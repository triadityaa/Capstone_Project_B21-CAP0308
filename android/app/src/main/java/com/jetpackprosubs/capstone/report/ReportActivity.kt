package com.jetpackprosubs.capstone.report

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.jetpackprosubs.capstone.R
import com.jetpackprosubs.capstone.data.Message
import com.jetpackprosubs.capstone.utils.Constants.RECEIVE_ID
import com.jetpackprosubs.capstone.utils.Constants.SEND_ID
import com.jetpackprosubs.capstone.utils.DummyResponse
import com.jetpackprosubs.capstone.utils.Time
import kotlinx.android.synthetic.main.activity_report.*
import kotlinx.coroutines.*

class ReportActivity : AppCompatActivity() {
    private lateinit var adapter: MessagingAdapter
    private val botList = listOf("Ayu", "Budi")

    var listPesan = mutableListOf<Message>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        recyclerView()
        pesanAwal("Aplikasi masih dalam tahap pengembangan")

        val random = (0..1).random()
        pesanAwal("Hallo, dengan ${botList[random]} disni, ada yang bisa saya bantu?\nketik, saya ingin lapor, untuk melapor")


        btn_send.setOnClickListener {
            kirim()
        }
        et_message.setOnClickListener {
            GlobalScope.launch {
                delay(1000)
                withContext(Dispatchers.Main){
                    rv_messages.scrollToPosition(adapter.itemCount-1)
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()

        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main){
                rv_messages.scrollToPosition(adapter.itemCount-1)
            }
        }
    }

    private fun recyclerView() {
        adapter = MessagingAdapter()
        rv_messages.adapter = adapter
        rv_messages.layoutManager = LinearLayoutManager(applicationContext)
    }

    private fun kirim(){
        val pesan = et_message.text.toString()
        val waktuPesan = Time.timeStamp()

        if (pesan.isNotEmpty()){
            listPesan.add(Message(pesan, SEND_ID, waktuPesan))
            et_message.setText("")

            adapter.setMsg(Message(pesan, SEND_ID, waktuPesan))
            rv_messages.scrollToPosition(adapter.itemCount -1)

            simpleRespons(pesan)
        }
    }

    private fun simpleRespons(pesan: String) {
        val waktuPesan = Time.timeStamp()
        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main){
                val respons = DummyResponse.simpleResponse(pesan)
                listPesan.add(Message(respons, RECEIVE_ID, waktuPesan))
                adapter.setMsg(Message(respons, RECEIVE_ID, waktuPesan))
                rv_messages.scrollToPosition(adapter.itemCount-1)
            }
        }
    }

    private fun pesanAwal(pesan: String) {
        val waktuPesan = Time.timeStamp()
        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main){
                listPesan.add(Message(pesan, RECEIVE_ID, waktuPesan))
                adapter.setMsg(Message(pesan, RECEIVE_ID, waktuPesan))
                rv_messages.scrollToPosition(adapter.itemCount-1)
            }
        }
    }
}