package com.example.myapplication.messaging.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.messaging.model.Attachment

class AttachmentAdapter(private val context: Context?, private val data: ArrayList<Attachment>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val audio = 0
        const val document = 1
        const val location = 2
        const val camera = 3
        const val contact = 4
        const val video = 5
        const val sender = 6
        const val receiver = 7
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            audio ->  AudioViewHolder(LayoutInflater.from(context).inflate(R.layout.item_audio,parent,false))
            document ->  DocumentViewHolder(LayoutInflater.from(context).inflate(R.layout.item_document,parent,false))
            location ->  LocationViewHolder(LayoutInflater.from(context).inflate(R.layout.item_location,parent,false))
            camera ->  CameraViewHolder(LayoutInflater.from(context).inflate(R.layout.item_camera,parent,false))
            contact ->  ContactViewHolder(LayoutInflater.from(context).inflate(R.layout.item_contact,parent,false))
            video ->  VideoViewHolder(LayoutInflater.from(context).inflate(R.layout.item_video,parent,false))
            sender ->  SenderViewHolder(LayoutInflater.from(context).inflate(R.layout.item_sender_message,parent,false))
            receiver ->  ReceiverViewHolder(LayoutInflater.from(context).inflate(R.layout.item_receiver_message,parent,false))
            else -> DocumentViewHolder(View(context))
        }
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (data[position].viewType) {
            audio -> (holder as AudioViewHolder).bind(position)
            document -> (holder as DocumentViewHolder).bind(position)
            location -> (holder as LocationViewHolder).bind(position)
            camera -> (holder as CameraViewHolder).bind(position)
            contact -> (holder as ContactViewHolder).bind(position)
            video -> (holder as VideoViewHolder).bind(position)
            sender -> (holder as SenderViewHolder).bind(position)
            receiver -> (holder as ReceiverViewHolder).bind(position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return data[position].viewType
    }
    private inner class AudioViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {}
    }
    private inner class DocumentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {}
    }
    private inner class LocationViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {}
    }
    private inner class CameraViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {}
    }
    private inner class ContactViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {}
    }
    private inner class VideoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(position: Int) {}
    }
    private inner class SenderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val content = itemView.findViewById<TextView>(R.id.sendingMessage)
        fun bind(position: Int) {
            content.text = data[position].userData.textMessage
        }
    }
    private inner class ReceiverViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val content = itemView.findViewById<TextView>(R.id.receivedMessage)
        fun bind(position: Int) {
            content.text = data[position].userData.textMessage
        }
    }
}