package com.example.cadastrofisioterapeuta

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Fisioterapeuta(
    @NonNull
    @PrimaryKey (autoGenerate = true) val id: Int,
    @ColumnInfo (name = "name") val name : String,
    @ColumnInfo (name = "crefito") val crefito : Int,
    @ColumnInfo (name = "sexo") val sexo : String
)