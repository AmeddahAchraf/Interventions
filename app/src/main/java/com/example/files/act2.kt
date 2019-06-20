package com.example.files

import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout


class act2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act)

        var prefs = getSharedPreferences("bgColour", Context.MODE_PRIVATE)

        var coleur = prefs.getString("couleur","WHITE")

        if (coleur == "RED"){
            findViewById<ConstraintLayout>(R.id.act).setBackgroundColor(Color.RED)
        } else {
            findViewById<ConstraintLayout>(R.id.act).setBackgroundColor(Color.GREEN)
        }


    }
}
