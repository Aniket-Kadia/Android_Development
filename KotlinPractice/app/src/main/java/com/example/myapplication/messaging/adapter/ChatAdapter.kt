package com.example.myapplication.messaging.adapter

import com.example.myapplication.messaging.model.UserModel
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class ChatAdapter(private val context: Context?, private val chats: ArrayList<UserModel>, private val callBack: (Int)-> Unit) :
    RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chat = chats[position]
        holder.apply {
            profileImage.setImageDrawable(context?.let {
                ResourcesCompat.getDrawable(
                    it.resources,
                    chat.imageURl,
                    null
                )
            })
            name.text = chat.name
            message.text = chat.message
            time.text = chat.time
            if (chat.unseenChatCount == 0) {
                unseenMessageCount.isVisible = false
            } else {
                unseenMessageCount.text = chat.unseenChatCount.toString()
            }
            itemView.setOnClickListener {
                callBack(position)
            }
        }
    }
    override fun getItemCount(): Int {
        return chats.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profileImage = itemView.findViewById<ImageView>(R.id.imgProfile)
        val name = itemView.findViewById<TextView>(R.id.tv_name)
        val message = itemView.findViewById<TextView>(R.id.tv_lastMessage)
        val time = itemView.findViewById<TextView>(R.id.time)
        val unseenMessageCount = itemView.findViewById<TextView>(R.id.unseenChatCount)
    }
}