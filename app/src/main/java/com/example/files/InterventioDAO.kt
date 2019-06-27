package com.example.files

import android.arch.persistence.room.*

@Dao
interface InterventioDAO{
    @Query("SELECT * FROM intervention")
    fun getInterventions() :  List<intervention>

    @Insert
    fun addInterventions(intervention: intervention)

    @Delete
    fun deleteIntervention(intervention: intervention)

    @Update
    fun update(intervention: intervention)




}