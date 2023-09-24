package com.example.myapplication.intent.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityReceiverBinding
import com.example.myapplication.utils.Constants

class ReceiverActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReceiverBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReceiverBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
    }
    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
            currentFocus?.clearFocus()
        }
        return super.dispatchTouchEvent(ev)
    }
    private fun setupView() {
        val data = intent.extras

        when(data?.getString(Constants.KEY_DATA_PASS)) {
            Constants.VALUE_INTENT ->  {
                val message = intent.getStringExtra(Constants.EXTRA_USER_MESSAGE)
                binding.textResponse.text = getString(R.string.msg_received) + message
            }

            Constants.VALUE_PARCELABLE -> {
                val employeeDetail = intent.getParcelableExtra<Employee>(Constants.EXTRA_EMPLOYEE_DATA)
                if (employeeDetail != null) {
                    binding.textResponse.text = "${getString(R.string.employee_details)} ${employeeDetail.name}, ${employeeDetail.department}"
                }
            }

            Constants.VALUE_SERIALIZABLE -> {
                val projectDetail = intent.getSerializableExtra(Constants.EXTRA_PROJECT_DATA) as Project
                binding.textResponse.text = "${getString(R.string.project_details)} ${projectDetail.projectID}, ${projectDetail.projectName}"
            }
        }

        binding.btnContract.setOnClickListener {
            val result = Intent().putExtra(Constants.KEY_REQUEST,binding.edtContract.text.toString())
            setResult(Activity.RESULT_OK, result)
            finish()
        }
    }
}