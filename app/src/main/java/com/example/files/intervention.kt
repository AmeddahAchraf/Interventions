package com.example.files


class intervention(var id:String, var numero: String, var date: String, var nomPlombier: String, var typeIntervention: String) {

    data class interv(
        var id:String,
        var numero: String,
        var date: String,
        var nomPlombier: String,
        var typeIntervention: String
    )

    data class arrayInterv(
        var array : ArrayList<interv>
    )

}