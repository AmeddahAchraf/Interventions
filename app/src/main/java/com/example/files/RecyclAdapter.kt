package com.example.files

import android.annotation.SuppressLint
import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.immoblier.AddDialog
import com.example.immoblier.UpdateDialog
import java.text.SimpleDateFormat


class HomeRecyclerViewAdapter(data : ArrayList<intervention>,internal var context : Context, internal var  fragmentManager: FragmentManager) : RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.intervention, parent, false)

        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.nom.text = data[position].nom
        holder.numero.text = data[position].numero.toString()
        holder.type.text = data[position].type
        holder.date.text = data[position].date.toString()

        holder.delete_btn.setOnClickListener{
            InterventionDB.getInstance(context)!!.interventionDao().deleteIntervention(data[position])
            this.update(ArrayList(InterventionDB.getInstance(context)!!.interventionDao().getInterventions()))
        }

        holder.update.setOnClickListener{
            val dialog = UpdateDialog()
            dialog.setIntervention(data[position])
            dialog.show(fragmentManager, "Update")
        }
        //val df = SimpleDateFormat("dd-MM-yy")
        //holder.date.text = df.format(data[position].date)
    }

    fun update(modelList:ArrayList<intervention>){
        data = modelList
        this!!.notifyDataSetChanged()
    }




    private var data : ArrayList<intervention> = data

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        internal var nom : TextView
        internal var date : TextView
        internal var type : TextView
        internal var numero : TextView
        internal var delete_btn : Button
        internal var update : Button


        init {
            nom = itemView.findViewById(R.id.tv_namee)
            numero = itemView.findViewById(R.id.tv_numero)
            type = itemView.findViewById(R.id.tv_type)
            date = itemView.findViewById(R.id.tv_date)
            delete_btn = itemView.findViewById(R.id.btn_dlt)
            update = itemView.findViewById(R.id.btn_up)
        }

    }
}