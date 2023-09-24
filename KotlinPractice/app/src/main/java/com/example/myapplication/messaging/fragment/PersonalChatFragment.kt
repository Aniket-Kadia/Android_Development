package com.example.myapplication.messaging.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentPersonalChatBinding
import com.example.myapplication.messaging.adapter.AttachmentAdapter
import com.example.myapplication.messaging.model.Attachment
import com.example.myapplication.messaging.model.UserMessages
import com.example.myapplication.messaging.model.getChatData
import com.example.myapplication.messaging.viewmodel.MessageHomeViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog

class PersonalChatFragment : Fragment() {
    private lateinit var binding: FragmentPersonalChatBinding
    private val messageHomeViewModels : MessageHomeViewModel by activityViewModels()
    private var dataList = ArrayList<Attachment>()
    private var chatId = 0
    private lateinit var adapter: AttachmentAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPersonalChatBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.back.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
        messageHomeViewModels.id.observe(viewLifecycleOwner) {
            chatId = it
            setupView()
        }
    }

    private fun setupView() {
        val chatData = getChatData()[chatId]
        binding.tvName.text = chatData.name
        binding.imgProfile.setImageResource(chatData.imageURl)
        binding.attachments.setOnClickListener {
            val dialog = context?.let { context -> BottomSheetDialog(context) }
            val view = layoutInflater.inflate(R.layout.item_attachment_card, null)
            val btnAudio = view.findViewById<ImageView>(R.id.audio)
            val btnDocument = view.findViewById<ImageView>(R.id.document)
            val btnLocation = view.findViewById<ImageView>(R.id.location)
            val btnCamera = view.findViewById<ImageView>(R.id.camera)
            val btnContact = view.findViewById<ImageView>(R.id.contact)
            val btnVideo = view.findViewById<ImageView>(R.id.video)
            if (dialog != null) {
                btnAudio.setOnClickListener {
                    dataList.add(Attachment(AttachmentAdapter.audio, UserMessages(getString(R.string.audio))))
                    adapter.notifyItemInserted(dataList.size - 1)
                    binding.contentArea.scrollToPosition(dataList.size - 1)
                    dialog.dismiss()
                }
                btnDocument.setOnClickListener {
                    dataList.add(Attachment(AttachmentAdapter.document, UserMessages(getString(R.string.docs))))
                    adapter.notifyItemInserted(dataList.size - 1)
                    binding.contentArea.scrollToPosition(dataList.size - 1)
                    dialog.dismiss()
                }
                btnLocation.setOnClickListener {
                    dataList.add(Attachment(AttachmentAdapter.location, UserMessages(getString(R.string.location))))
                    adapter.notifyItemInserted(dataList.size - 1)
                    binding.contentArea.scrollToPosition(dataList.size - 1)
                    dialog.dismiss()
                }
                btnCamera.setOnClickListener {
                    dataList.add(Attachment(AttachmentAdapter.camera, UserMessages(getString(R.string.camera))))
                    adapter.notifyItemInserted(dataList.size - 1)
                    binding.contentArea.scrollToPosition(dataList.size - 1)
                    dialog.dismiss()
                }
                btnContact.setOnClickListener {
                    dataList.add(Attachment(AttachmentAdapter.contact, UserMessages(getString(R.string.contact))))
                    adapter.notifyItemInserted(dataList.size - 1)
                    binding.contentArea.scrollToPosition(dataList.size - 1)
                    dialog.dismiss()
                }
                btnVideo.setOnClickListener {
                    dataList.add(Attachment(AttachmentAdapter.video, UserMessages(getString(R.string.video))))
                    adapter.notifyItemInserted(dataList.size - 1)
                    binding.contentArea.scrollToPosition(dataList.size - 1)
                    dialog.dismiss()
                }
                dialog.setContentView(view)
                dialog.show()
            }
        }

        dataList = arrayListOf(
            Attachment(AttachmentAdapter.document, UserMessages(getString(R.string.audio))),
            Attachment(AttachmentAdapter.audio, UserMessages(getString(R.string.audio))),
            Attachment(AttachmentAdapter.audio, UserMessages(getString(R.string.audio))),
            Attachment(AttachmentAdapter.sender, UserMessages(getString(R.string.hello))),
            Attachment(AttachmentAdapter.sender, UserMessages(getString(R.string.chat_meeting_time))),
            Attachment(AttachmentAdapter.receiver, UserMessages(getString(R.string.chat_reponse))),
            Attachment(AttachmentAdapter.sender, UserMessages(getString(R.string.chat_great)))
        )
        val layoutManager = LinearLayoutManager(context).apply {
            reverseLayout = false
            stackFromEnd = true
        }
        binding.contentArea.scrollToPosition(0)
        binding.contentArea.layoutManager = layoutManager
        adapter = AttachmentAdapter(context,dataList)
        binding.contentArea.adapter = adapter
        val message = binding.textMessage
        binding.textMessage.addTextChangedListener {
            binding.btnSend.isVisible = message.text.toString().isNotEmpty()
        }
        binding.btnSend.setOnClickListener {
            if(message.text.toString().isNotEmpty()) {
                dataList.add(Attachment(AttachmentAdapter.sender, UserMessages(message.text.toString().trim())))
                adapter.notifyItemInserted(dataList.size - 1)
                binding.contentArea.scrollToPosition(dataList.size - 1)
                binding.textMessage.setText("")
            }
        }
    }
}