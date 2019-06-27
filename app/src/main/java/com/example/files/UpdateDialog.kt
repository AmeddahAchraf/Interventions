package com.example.immoblier

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatDialogFragment
import android.text.Editable
import android.text.InputType
import android.view.View
import android.widget.*
import com.example.files.R
import com.example.files.intervention
import java.text.SimpleDateFormat
import java.util.*

class UpdateDialog() : AppCompatDialogFragment() , AdapterView.OnItemSelectedListener{

    private lateinit var filterBtn : Button
    private lateinit var updateDialogListener: UpdateDialogListener
    private  var selectedType  = ""

    private lateinit var curruntIntervention : intervention

    fun setIntervention(intervention: intervention){
        this.curruntIntervention = intervention
    }
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {


        val builder = AlertDialog.Builder(activity)
        val inflater = activity?.layoutInflater

        val view = inflater?.inflate(R.layout.update, null)

        builder.setView(view)


        filterBtn = view!!.findViewById(R.id.btn_update)
        filterBtn.setText(R.string.update)
        filterBtn.setOnClickListener {

            val nom = view.findViewById<EditText>(R.id.et_nom_up).text.toString()
            val type = view.findViewById<EditText>(R.id.et_type_up).text.toString()



           val df = SimpleDateFormat("dd-MM-yy")
            updateDialogListener.updateIntervention(curruntIntervention.numero.toString(),nom,df.format(Date()),type)
            this.dismiss()
        }
        return builder.create()

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        updateDialogListener = context as UpdateDialogListener
    }
    interface UpdateDialogListener{
        fun updateIntervention(numero : String, nom : String, Date : String, type : String)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {


    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        selectedType = parent?.getItemAtPosition(position).toString()

    }


}