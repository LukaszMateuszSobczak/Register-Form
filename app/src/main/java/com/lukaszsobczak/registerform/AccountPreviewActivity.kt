package com.lukaszsobczak.registerform

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.lukaszsobczak.registerform.databinding.ActivityAccountPrevievBinding
import com.lukaszsobczak.registerform.databinding.ActivityMainBinding

class AccountPreviewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAccountPrevievBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountPrevievBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayAccountDataToUser()

        binding.cardViewEmail.setOnClickListener {
            newEmail()
        }

        binding.cardViewPhone.setOnClickListener {
            newSms()
        }

    }

    private fun displayAccountDataToUser() {
        val intentData = intent.getSerializableExtra("objectInstance") as Account

        val nameWithPrefix = "${intentData.prefix} ${intentData.name}"

        binding.textViewNameContent.text = nameWithPrefix
        binding.textViewSurnameContent.text = intentData.surname
        binding.textViewEmailContent.text = intentData.email
        binding.textViewPhoneContent.text = intentData.phone
        binding.textViewPasswordContent.text = intentData.password

    }

    private fun newSms() {
        val smsIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("smsto:")
        }
        startActivity(smsIntent)
    }

    private fun newEmail() {
        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, "sobczak.lukasz.mateusz@gmail.com")
        }
        startActivity(emailIntent)
    }
}