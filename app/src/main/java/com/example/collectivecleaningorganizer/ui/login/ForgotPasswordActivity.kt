package com.example.collectivecleaningorganizer.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.collectivecleaningorganizer.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_forgot_password.*

class ForgotPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        forgottPasswordBackButton.setOnClickListener {
            // sends user back to login page
            startActivity(Intent(this, LoginActivity::class.java))
        }

        submitButton.setOnClickListener {
            val email = forgotPasswordEmail.text.toString() // gets email entered by user

            // Sends reset password email to user
            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener{task ->
                    if (task.isSuccessful){
                        // displays message to user
                        Toast.makeText(this, "A email to reset your password has been sent",
                        Toast.LENGTH_LONG).show()       // used length long to display message for 5 seconds

                        finish()      // takes the user back to login activity

                    } else {
                        Toast.makeText(this, "Could not successfully send email",
                            Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}

