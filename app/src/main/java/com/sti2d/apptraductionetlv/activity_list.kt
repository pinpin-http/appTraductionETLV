package com.sti2d.apptraductionetlv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class activity_list : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        //importation et declaration de l'item btn
        val previousPage = findViewById<ImageButton>(R.id.returnButton)

        previousPage.setOnClickListener(View.OnClickListener {
            val intentToPreviousPage : Intent = Intent(this,MainActivity::class.java)
            startActivity(intentToPreviousPage)
        })

    }
}