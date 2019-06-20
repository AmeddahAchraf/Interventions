package com.example.files
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.google.gson.Gson
import java.io.InputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*var red = findViewById<Button>(R.id.red)
        var green = findViewById<Button>(R.id.green)
        var goto = findViewById<Button>(R.id.go)

        val prefs = getSharedPreferences("bgColour", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        var coleur = prefs.getString("couleur","WHITE")

        if (coleur == "RED"){
            findViewById<ConstraintLayout>(R.id.main).setBackgroundColor(Color.RED)
        } else if (coleur == "GREEN"){
            findViewById<ConstraintLayout>(R.id.main).setBackgroundColor(Color.GREEN)
        } else {
            findViewById<ConstraintLayout>(R.id.main).setBackgroundColor(Color.WHITE)
        }

        red.setOnClickListener {
            editor.putString("couleur","RED")
            editor.commit()
            findViewById<ConstraintLayout>(R.id.main).setBackgroundColor(Color.RED)

        }

        green.setOnClickListener {
            editor.putString("couleur","GREEN")
            editor.commit()
            findViewById<ConstraintLayout>(R.id.main).setBackgroundColor(Color.GREEN)
        }

        goto.setOnClickListener {
            var go  = Intent(this,act2::class.java)
            startActivity(go)
        }*/

        val inputStream: InputStream = assets.open("intervention.json")
        val inputStreamReader = InputStreamReader(inputStream)
        var gson = Gson()


        var first = gson?.fromJson(inputStreamReader, intervention.arrayInterv::class.java)
        var announcementRecycler = findViewById<RecyclerView>(R.id.recycleView)
        var adapter = HomeRecyclerViewAdapter(first.array, applicationContext)

        announcementRecycler.layoutManager = LinearLayoutManager(applicationContext)
        announcementRecycler.adapter = adapter


    }
}
