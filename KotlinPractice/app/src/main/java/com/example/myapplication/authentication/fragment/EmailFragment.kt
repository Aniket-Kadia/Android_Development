package com.example.myapplication.authentication.fragment

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import com.example.myapplication.R
import com.example.myapplication.authentication.viewmodel.EmailViewModel
import com.example.myapplication.databinding.FragmentEmailBinding
import com.example.myapplication.homepage.activity.HomePageActivity
import com.example.myapplication.utils.Constants
import com.example.myapplication.utils.PreferenceManager
import com.example.myapplication.utils.Validation
import com.example.myapplication.utils.showErrorDiscription
import com.google.android.material.snackbar.Snackbar

class EmailFragment : Fragment() {
    private lateinit var binding: FragmentEmailBinding
    private val emailViewModel: EmailViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_email, container, false)
        setupView()
        setObserver()
        return binding.root
    }

    private fun setObserver() {
        emailViewModel.validation.observe(this) {
            when (it) {
                Validation.EMPTY_EMAIL -> binding.edtEmail.error = it.message
                Validation.NOT_VALID_EMAIL -> binding.edtEmail.error = it.message
                Validation.EMPTY_PASSWORD -> binding.edtPassword.error = it.message
                Validation.NOT_VALID_PASSWORD -> binding.edtPassword.error = it.message
                else -> {
                    return@observe
                }
            }
        }

        emailViewModel.isSuccessful.observe(this) {
            if (it == 0) {
                val intent = Intent(requireContext(), HomePageActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                activity?.finish()
            } else {
                Snackbar.make(
                    binding.viewMain, R.string.err_invalid_credentials, Snackbar.LENGTH_LONG
                ).show()
            }
        }

        emailViewModel.isUnsuccessful.observe(this) {
            context?.let { context ->
                if (it != null) {
                    showErrorDiscription(context,it)
                }
            }
        }

        emailViewModel.setToken.observe(this) {
            context?.let { context ->
                PreferenceManager.setPreference(context, Constants.KEY_TOKEN, it)
                PreferenceManager.setPreference(context,Constants.KEY_LOGIN_STATUS, "true")
            }
        }

        emailViewModel.setUserProfileName.observe(this) {
            context?.let { context ->
                PreferenceManager.setPreference(context, Constants.KEY_USERNAME, it)
            }
        }
    }

    private fun setupView() {
        binding.emailViewModel = emailViewModel
        binding.lifecycleOwner = this
        binding.btnLogin.isEnabled = false

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.btnLogin.isEnabled =
                    binding.edtEmail.text.toString().isNotEmpty() && binding.edtPassword.text.toString().isNotEmpty()
            }
            override fun afterTextChanged(p0: Editable?) {}
        }

        binding.edtEmail.addTextChangedListener(textWatcher)
        binding.edtPassword.addTextChangedListener(textWatcher)
    }
}