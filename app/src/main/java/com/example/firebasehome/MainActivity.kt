package com.example.firebasehome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var Password: EditText
    private lateinit var Email: EditText
    private lateinit var Button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Password = findViewById(R.id.Password)
        Email = findViewById(R.id.Email)
        Button = findViewById(R.id.Button)

        Button.setOnClickListener {
            val Email = Email.text.toString()
            val Password = Password.text.toString()

            if (Email.isEmpty() || Password.isEmpty()) {
                Toast.makeText(this, "გთხოვთ შეავსოთ ორივე ველი", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(Email, Password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "წარმატებული ოპერაცია", Toast.LENGTH_SHORT)
                            .show()

                    } else {
                        Toast.makeText(this, "დაფიქსირდა შეცდომა", Toast.LENGTH_SHORT).show()
                    }


                }
        }
    }
}