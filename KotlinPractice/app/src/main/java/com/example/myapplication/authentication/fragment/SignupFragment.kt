package com.example.myapplication.authentication.fragment

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
import com.example.myapplication.authentication.viewmodel.SignUpViewModel
import com.example.myapplication.databinding.FragmentSignupBinding
import com.example.myapplication.utils.Validation
import com.example.myapplication.utils.showErrorDiscription
import com.google.android.material.snackbar.Snackbar

class SignupFragment : Fragment() {
    lateinit var binding: FragmentSignupBinding
    private val signUpViewModel: SignUpViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_signup, container, false)
        setupView()
        setObserver()
        return binding.root
    }

    private fun setObserver() {
        signUpViewModel.validation.observe(this) {
            when (it) {
                Validation.EMPTY_NAME -> binding.edtName.error = it.message
                Validation.EMPTY_EMAIL -> binding.edtEmail.error = it.message
                Validation.NOT_VALID_EMAIL -> binding.edtEmail.error = it.message
                Validation.EMPTY_PASSWORD -> binding.edtPassword.error = it.message
                Validation.NOT_VALID_PASSWORD -> binding.edtPassword.error = it.message
                else -> {
                    return@observe
                }
            }
        }

        signUpViewModel.isSuccessful.observe(this) {
            if (it == 0) {
                val successfulMessage = Snackbar.make(
                    binding.viewMain, R.string.msg_account_create_successful, Snackbar.LENGTH_LONG
                )
                successfulMessage.setAction(R.string.action_ok, View.OnClickListener {
                    parentFragmentManager.commit {
                        replace(R.id.fragment_container, LoginFragment())
                        addToBackStack(null)
                    }
                })
                successfulMessage.show()
            } else {
                Snackbar.make(
                    binding.viewMain, R.string.msg_already_email_register, Snackbar.LENGTH_LONG
                ).show()
            }
        }

        signUpViewModel.isUnsuccessful.observe(this) {
            context?.let { context ->
                if (it != null) {
                    showErrorDiscription(context,it)
                }
            }
        }
    }

    private fun setupView() {
        binding.signUpViewModel = signUpViewModel
        binding.lifecycleOwner = this
        binding.btnSubmit.isEnabled = false

        binding.textGoLogin.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_container, LoginFragment())
                addToBackStack(null)
            }
        }

        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.btnSubmit.isEnabled =
                    binding.edtName.text.toString().isNotEmpty() && binding.edtEmail.text.toString()
                        .isNotEmpty() && binding.edtPassword.text.toString().isNotEmpty()
            }
            override fun afterTextChanged(p0: Editable?) {}
        }

        binding.edtName.addTextChangedListener(textWatcher)
        binding.edtEmail.addTextChangedListener(textWatcher)
        binding.edtPassword.addTextChangedListener(textWatcher)
    }
}