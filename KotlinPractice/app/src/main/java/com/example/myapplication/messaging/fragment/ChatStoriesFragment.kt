package com.example.myapplication.messaging.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentChatStoriesBinding
import com.example.myapplication.messaging.adapter.ChatAdapter
import com.example.myapplication.messaging.model.getChatData
import com.example.myapplication.messaging.viewmodel.MessageHomeViewModel

class ChatStoriesFragment : Fragment() {
    private lateinit var binding: FragmentChatStoriesBinding
    private lateinit var adapter: ChatAdapter
    private val messageHomeViewModel : MessageHomeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatStoriesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataPassCallback = {data:Int ->
            onClick(data)
        }
        adapter = ChatAdapter(context, getChatData(),dataPassCallback)
        binding.chatStoriesList.adapter = adapter
        binding.chatStoriesList.addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
    }

    private fun onClick(data: Int) {
        messageHomeViewModel.updateID(data)
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, PersonalChatFragment()).addToBackStack(null).commit()
    }
}