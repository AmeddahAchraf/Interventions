package com.example.files

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*
import kotlin.collections.ArrayList

@Entity()
class intervention(@PrimaryKey var numero: Int
                   ,@ColumnInfo(name = "date") var date: String,
                   @ColumnInfo(name = "Nom") var nom : String,
                   @ColumnInfo(name = "Type") var type : String
) {


}