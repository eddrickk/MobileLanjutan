package com.example.pertemuan2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun sendData(view: View) {
        var IntentToMain = Intent(this, MainActivity::class.java)
        var text = edittext.text.toString()
        var pass = edittext2.text.toString()
        IntentToMain.putExtra("123",text)
        IntentToMain.putExtra("1234",pass)
        startActivity(IntentToMain)
    }
}