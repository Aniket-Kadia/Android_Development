package com.example.myapplication.authentication.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.example.myapplication.R
import com.example.myapplication.authentication.adapter.ViewPagerAdapter
import com.example.myapplication.databinding.FragmentLoginBinding
import com.google.android.material.tabs.TabLayoutMediator

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val authenticationTabList = resources.getStringArray(R.array.authenticationTab)
        binding.vpPhoneEmail.adapter = ViewPagerAdapter(parentFragmentManager, lifecycle)

        TabLayoutMediator(binding.tabPhoneEmail, binding.vpPhoneEmail) { tab, position ->
            if (position == 0) {
                tab.text = authenticationTabList[0]
            } else {
                tab.text = authenticationTabList[1]
            }
        }.attach()

        binding.textGoSignup.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, SignupFragment())
                addToBackStack(null)
            }
        }
    }
}