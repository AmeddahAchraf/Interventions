package com.example.files

import android.annotation.SuppressLint
import android.content.Context

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class HomeRecyclerViewAdapter(data : ArrayList<intervention.interv>,internal var context : Context) : RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.intervention, parent, false)

        return ViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.id.text = data[position].id
        holder.nom.text = data[position].nomPlombier
        holder.numero.text = data[position].numero
        holder.type.text = data[position].typeIntervention
        holder.date.text = data[position].date

    }


    private var data : ArrayList<intervention.interv> = data

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        internal var id : TextView
        internal var nom : TextView
        internal var date : TextView
        internal var type : TextView
        internal var numero : TextView

        init {
            id = itemView.findViewById(R.id.tv_idd)
            nom = itemView.findViewById(R.id.tv_namee)
            numero = itemView.findViewById(R.id.tv_numero)
            type = itemView.findViewById(R.id.tv_type)
            date = itemView.findViewById(R.id.tv_date)

        }


    }
}