package com.example.files
import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.JsonWriter
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.example.immoblier.AddDialog
import com.example.immoblier.UpdateDialog
import com.google.gson.Gson
import java.io.*
import java.util.*
class MainActivity : AppCompatActivity() , AddDialog.AddDialogListener, UpdateDialog.UpdateDialogListener{



    private lateinit var toolbar: Toolbar
    private lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        createToolbar()



        recyclerView  = findViewById<RecyclerView>(R.id.recycleView)

       val adapter = HomeRecyclerViewAdapter(getInterventions(), applicationContext, supportFragmentManager)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.adapter = adapter


    }

    private fun createToolbar(){

        toolbar = findViewById(R.id.homeViewToolBar)
        setSupportActionBar(toolbar)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.home_view_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId){

            R.id.add -> {openAddDialog()}

        }
        return super.onOptionsItemSelected(item)
    }

    private fun openAddDialog() {
        val dialog = AddDialog()
        dialog.show(supportFragmentManager, "AddDialog")
    }

    private fun getInterventions() : ArrayList<intervention>{




       val interventions = InterventionDB.getInstance(this)!!.interventionDao().getInterventions()

        return ArrayList(interventions)
    }


    override fun addAnnouncement(numero: String, nom: String, Date: String, type: String) {
        InterventionDB.getInstance(this)!!.interventionDao().addInterventions(intervention(numero.toInt(), Date,nom,type))
        val adapter = HomeRecyclerViewAdapter(getInterventions(), applicationContext, supportFragmentManager)
        recyclerView.adapter = adapter
    }

    override fun updateIntervention(numero: String, nom: String, Date: String, type: String) {
        Log.i("Update","OK")
        InterventionDB.getInstance(this)!!.interventionDao().update(intervention(numero.toInt(), Date,nom,type))
        val adapter = HomeRecyclerViewAdapter(getInterventions(), applicationContext, supportFragmentManager)
        recyclerView.adapter = adapter
    }
}
