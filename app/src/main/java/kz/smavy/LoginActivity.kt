package kz.smavy

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity(), OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val editText = findViewById<EditText>(R.id.editText)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener(this)
    }



    override fun onClick(clicked: View?) {
        val prefs: SharedPreferences = getSharedPreferences("TOKEN", Context.MODE_PRIVATE)

        val editor = prefs.edit()
        editor.putString("token", "LOGGED IN")
        editor.apply()

        finish()
    }


}