package com.example.sendmessage_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

import androidx.appcompat.app.AppCompatActivity


class SendMessageActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_message)
        val editTextMessage = findViewById<EditText>(R.id.editTextMessage)
        val btSend = findViewById<Button>(R.id.btSend)

        //editTextMessage.text
        btSend.setOnClickListener {
            val intent = Intent(this, ViewMessageActivity::class.java)
            val bundle = Bundle()
            bundle.putString("KEY_MESSAGE", editTextMessage.text.toString())
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }


}