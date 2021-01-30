package com.example.davaleba6

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }
    private fun init(){
        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE)

        val email = sharedPreferences.getString("email", "")
        val name = sharedPreferences.getString("name", "")
        val lastName = sharedPreferences.getString("lastName", "")
        val age = sharedPreferences.getString("age", "")
        val address = sharedPreferences.getString("address", "")

        emailInput.setText(email)
        nameInput.setText(name)
        lastNameInput.setText(lastName)
        ageInput.setText(age)
        addressInput.setText(address)

        saveButton.setOnClickListener {
            val currentEmail = emailInput.text.toString()
            val currentName = nameInput.text.toString()
            val currentLastName = lastNameInput.text.toString()
            val currentAge = ageInput.text.toString()
            val currentAddress = addressInput.text.toString()
            if(currentEmail.isNotEmpty() && currentName.isNotEmpty() && currentLastName.isNotEmpty() && currentAge.isNotEmpty() && currentAddress.isNotEmpty()){
                val save = sharedPreferences.edit()
                save.putString("email", currentEmail)
                save.putString("name", currentName)
                save.putString("lastName", currentLastName)
                save.putString("age", currentAge)
                save.putString("address", currentAddress)
                save.apply()
                Toast.makeText(this, "Data saved", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Fill in all fields before saving", Toast.LENGTH_LONG).show()
            }
        }
    }
}