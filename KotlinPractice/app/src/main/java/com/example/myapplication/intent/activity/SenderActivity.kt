package com.example.myapplication.intent.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import com.example.myapplication.databinding.ActivitySenderBinding
import com.example.myapplication.utils.Constants
import java.io.Serializable

class SenderActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySenderBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySenderBinding.inflate(layoutInflater)
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
        val intent = Intent(this, ReceiverActivity::class.java)
        val message = binding.edtUserResponse.text

        binding.btnIntent.setOnClickListener {
            intent.putExtra(Constants.EXTRA_USER_MESSAGE, message.toString())
            intent.putExtra(Constants.KEY_DATA_PASS, Constants.VALUE_INTENT)
            startActivity(intent)
        }

        binding.btnParcelable.setOnClickListener {
            intent.putExtra(Constants.EXTRA_EMPLOYEE_DATA, Employee("Thomas", "Android"))
            intent.putExtra(Constants.KEY_DATA_PASS, Constants.VALUE_PARCELABLE)
            startActivity(intent)
        }

        binding.btnSerializable.setOnClickListener {
            intent.putExtra(Constants.EXTRA_PROJECT_DATA, Project(771, "StarLink"))
            intent.putExtra(Constants.KEY_DATA_PASS, Constants.VALUE_SERIALIZABLE)
            startActivity(intent)
        }

        binding.btnContract.setOnClickListener {
            messageContract.launch(Unit)
        }
    }

    private val messageContract = registerForActivityResult(MessageContract()) { result ->
        Toast.makeText(applicationContext, result, Toast.LENGTH_LONG).show()
    }
}

data class Employee(val name: String?, val department: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(department)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Employee> {
        override fun createFromParcel(parcel: Parcel): Employee {
            return Employee(parcel)
        }

        override fun newArray(size: Int): Array<Employee?> {
            return arrayOfNulls(size)
        }
    }
}

data class Project(val projectID: Int, val projectName: String) : Serializable

class MessageContract : ActivityResultContract<Unit, String>() {
    override fun createIntent(context: Context, input: Unit): Intent =
        Intent(context, ReceiverActivity::class.java)

    override fun parseResult(resultCode: Int, intent: Intent?): String {
        val message = intent?.getStringExtra(Constants.KEY_REQUEST)
        return if (resultCode == Activity.RESULT_OK && message != null) message else ""
    }
}