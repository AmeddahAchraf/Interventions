package com.example.files

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = arrayOf(intervention::class), version = 1)
abstract class InterventionDB : RoomDatabase(){
    abstract fun interventionDao(): InterventioDAO

    companion object {
        private var instance: InterventionDB? = null
        fun getInstance(context: Context): InterventionDB? {
            if (instance == null) {
                instance =
                    Room.databaseBuilder(context.getApplicationContext(),
                        InterventionDB::class.java, "intervention.db")
                        .allowMainThreadQueries().build()
            }
            return instance
        }
        fun destroyInstance() {
            instance = null
        }
}
}