package com.stuick.selfpromoapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.button_preview_message
import kotlinx.android.synthetic.main.activity_preview.button_send_message
import kotlinx.android.synthetic.main.activity_preview.text_view_message

class PreviewActivity : AppCompatActivity() {
    private lateinit var message: Message
    private lateinit var messagePreviewText: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)

        displayMessage()
        setupButton()
    }

    private fun displayMessage() {
        // Ignore the deprecated message for the code to also work on older version of android
        message = intent.getSerializableExtra("Message") as Message
        messagePreviewText = """
                Hi ${message.contactName},
                
                My name is ${message.myDisplayName} and I am ${message.getFullJobDescription()}.
                
                I have a portfolio of apps to demonstrate my technical skills that I can show on request.
                
                I am able to start a new position ${message.getAvailability()}.
                
                Please get in touch if you have any suitable roles for me.
                
                Thanks and best regards.
            """.trimIndent()

        text_view_message.text = messagePreviewText
    }

    private fun setupButton(){
        button_send_message.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto: ${message.contactNumber}")
                putExtra("sms_body", messagePreviewText)
            }
            startActivity(intent)
        }
    }

}