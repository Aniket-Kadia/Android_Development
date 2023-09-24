package com.example.myapplication.authentication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentPhoneBinding

class PhoneFragment : Fragment() {
    private lateinit var binding: FragmentPhoneBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentPhoneBinding.inflate(layoutInflater)
        return binding.root
    }
}