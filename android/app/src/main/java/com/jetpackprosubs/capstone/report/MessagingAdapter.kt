package com.jetpackprosubs.capstone.report

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jetpackprosubs.capstone.R
import com.jetpackprosubs.capstone.data.Message
import com.jetpackprosubs.capstone.utils.Constants.RECEIVE_ID
import com.jetpackprosubs.capstone.utils.Constants.SEND_ID
import kotlinx.android.synthetic.main.holder_message.view.*

class MessagingAdapter: RecyclerView.Adapter<MessagingAdapter.MessageViewHolder>() {
    var messageList = mutableListOf<Message>()
    inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init {
            itemView.setOnClickListener {
                messageList.removeAt(absoluteAdapterPosition)
                notifyItemRemoved(absoluteAdapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.holder_message, parent,false))
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val currentMsg = messageList[position]

        when(currentMsg.id){
            SEND_ID ->{
                holder.itemView.tv_message.apply {
                    text =currentMsg.message
                    visibility = View.VISIBLE
                }
                holder.itemView.tv_bot_message.apply {
                    visibility = View.GONE
                }
            }
            RECEIVE_ID ->{
                holder.itemView.tv_bot_message.apply {
                    text =currentMsg.message
                    visibility = View.VISIBLE
                }
                holder.itemView.tv_message.apply {
                    visibility = View.GONE
                }
            }
        }
    }

    override fun getItemCount(): Int = messageList.size

    fun setMsg(message: Message){
        this.messageList.add(message)
        notifyItemInserted(messageList.size)
    }
}