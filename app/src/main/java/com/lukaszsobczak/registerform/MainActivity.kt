package com.lukaszsobczak.registerform

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Carousel.Adapter
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lukaszsobczak.registerform.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createSpinner()
        onSignUpButton()

    }

    private fun onSignUpButton() {
        binding.buttonSignUp.setOnClickListener{

            val data: Account = Account(
                binding.spinnerPrefix.selectedItem.toString(),
                binding.editTextName.text.toString(),
                binding.editTextSurname.text.toString(),
                binding.editTextMail.text.toString(),
                binding.editTextPhone.text.toString(),
                binding.editTextPassword.text.toString()
            )

            val accountPreviewIntent = Intent(this, AccountPreviewActivity::class.java)
            accountPreviewIntent.putExtra("objectInstance", data)
            startActivity(accountPreviewIntent)
        }
    }

    private fun createSpinner() {
        val spinnerValues: Array<String> = arrayOf("Miss", "Mrs.", "Mr.", "Ms.")
        val spinnerAdapter = ArrayAdapter(
            this,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            spinnerValues
        )
        binding.spinnerPrefix.adapter = spinnerAdapter
    }
}