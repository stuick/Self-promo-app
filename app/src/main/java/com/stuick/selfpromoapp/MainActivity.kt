package com.stuick.selfpromoapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.button_preview_message
import kotlinx.android.synthetic.main.activity_main.check_box_immediate_start
import kotlinx.android.synthetic.main.activity_main.check_box_junior
import kotlinx.android.synthetic.main.activity_main.edit_text_contact_name
import kotlinx.android.synthetic.main.activity_main.edit_text_contact_number
import kotlinx.android.synthetic.main.activity_main.edit_text_display_name
import kotlinx.android.synthetic.main.activity_main.edit_text_start_date
import kotlinx.android.synthetic.main.activity_main.spinner_job_title

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_preview_message.setOnClickListener {
//            Toast.makeText(this, "my Button works", Toast.LENGTH_LONG).show()
            onPreviewClicked()
        }

        val spinnerValues: Array<String> = arrayOf("Android Developer", "Android Engineer")
        val spinnerAdapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_dropdown_item, spinnerValues)
        spinner_job_title.adapter = spinnerAdapter
    }

    private fun onPreviewClicked() {
//        val contactName = edit_text_contact_name.text.toString()
//        val contactNumber = edit_text_contact_number.text.toString()
//        val myDisplayName = edit_text_display_name.text.toString()
//        val includeJunior = check_box_junior.isChecked
//        val jobTitle = spinner_job_title.selectedItem?.toString()
//        val immediateStart = check_box_immediate_start.isChecked
//        val startDate = edit_text_start_date.text.toString()

        val message = Message(
            edit_text_contact_name.text.toString(),
            edit_text_contact_number.text.toString(),
            edit_text_display_name.text.toString(),
            check_box_junior.isChecked,
            spinner_job_title.selectedItem?.toString(),
            check_box_immediate_start.isChecked,
            edit_text_start_date.text.toString()
        )

        val previewActivityIntent = Intent(this, PreviewActivity::class.java)
        previewActivityIntent.putExtra("Message", message)

//        previewActivityIntent.putExtra("Contact Name", contactName)
//        previewActivityIntent.putExtra("Contact Number", contactNumber)
//        previewActivityIntent.putExtra("My Display Name", myDisplayName)
//        previewActivityIntent.putExtra("Include Junior", includeJunior)
//        previewActivityIntent.putExtra("Job Title", jobTitle)
//        previewActivityIntent.putExtra("Immediate Start", immediateStart)
//        previewActivityIntent.putExtra("Start Date", startDate)

        startActivity(previewActivityIntent)

    }
}