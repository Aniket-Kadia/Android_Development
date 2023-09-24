package com.example.myapplication.intent.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentCompanyResponseBinding

class CompanyResponseFragment : Fragment() {
    private lateinit var binding: FragmentCompanyResponseBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentCompanyResponseBinding.inflate(layoutInflater)
        setFragmentResultListener(com.example.myapplication.utils.Constants.KEY_REQUEST) { requestKey, bundle ->
            val result = bundle.getString(com.example.myapplication.utils.Constants.BUNDLE_QUERY)
            binding.textResponse.text = getString(R.string.response_confirmation_message) + result
        }
        return binding.root
    }
}