package com.example.myapplication.intent.fragment

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.setFragmentResult
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentCompanyIntroBinding
import com.example.myapplication.utils.Constants

class CompanyIntroFragment : Fragment() {
    private lateinit var binding: FragmentCompanyIntroBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCompanyIntroBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmit.setOnClickListener {
            val result = binding.edtQuery.text.toString()
            setFragmentResult(Constants.KEY_REQUEST, bundleOf(Constants.BUNDLE_QUERY to result))
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, CompanyResponseFragment()).addToBackStack(null)
                .commit()
        }

        val pickMedia =
            registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
                if (uri != null) {
                    binding.profile.setImageURI(uri)
                    binding.profile.isVisible = true
                } else {
                    return@registerForActivityResult
                }
            }

        binding.btnRequestImage.setOnClickListener {
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }

        binding.btnLocation.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(getString(R.string.url_office_location))
            }
            val chooser = Intent.createChooser(intent, null)
            try {
                startActivity(chooser)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(context, getString(R.string.err_data_not_handle), Toast.LENGTH_LONG)
                    .show()
            }
        }

        binding.btnGoToMail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse(getString(R.string.mailTo))
                putExtra(Intent.EXTRA_EMAIL, getString(R.string.email_address))
                putExtra(Intent.EXTRA_SUBJECT, getString(R.string.title_mail))
            }
            startActivity(intent)
        }

        binding.btnCall.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse(getString(R.string.phone_no))
            startActivity(dialIntent)
        }

        binding.btnGotoWebsite.setOnClickListener {
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(getString(R.string.url_website))
            startActivity(openURL)
        }
    }
}