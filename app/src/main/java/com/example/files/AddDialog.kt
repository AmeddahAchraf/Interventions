package com.example.immoblier

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatDialogFragment
import android.view.View
import android.widget.*
import com.example.files.R
import com.example.files.intervention
import java.text.SimpleDateFormat
import java.util.*

class AddDialog() : AppCompatDialogFragment() , AdapterView.OnItemSelectedListener{

    private lateinit var filterBtn : Button
    private lateinit var addDialogListener: AddDialogListener
    private  var selectedType  = ""


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {


        val builder = AlertDialog.Builder(activity)
        val inflater = activity?.layoutInflater

        val view = inflater?.inflate(R.layout.add, null)

        builder.setView(view)



        filterBtn = view!!.findViewById(R.id.btn_add)
        filterBtn.setOnClickListener {

            val numero = view.findViewById<EditText>(R.id.et_numero).text.toString()
            val nom = view.findViewById<EditText>(R.id.et_nom).text.toString()
            val type = view.findViewById<EditText>(R.id.editText4).text.toString()


           val df = SimpleDateFormat("dd-MM-yy")
            addDialogListener.addAnnouncement(numero,nom,df.format(Date()),type)
            this.dismiss()
        }
        return builder.create()

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        addDialogListener = context as AddDialogListener
    }
    interface AddDialogListener{
        fun addAnnouncement(numero : String, nom : String, Date : String, type : String)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {


    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        selectedType = parent?.getItemAtPosition(position).toString()

    }

}