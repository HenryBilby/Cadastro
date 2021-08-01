package com.example.cadastrofisioterapeuta

import androidx.room.*

@Dao
interface FisioterapeutaDAO {
    @Query("SELECT * FROM fisioterapeuta")
    suspend fun getFisioterapeuta() : List<Fisioterapeuta>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFisioterapeuta(fisioterapeuta: Fisioterapeuta)

    @Insert
    suspend fun insertFisioterapeuta(vararg fisioterapeuta: Fisioterapeuta)

    @Update
    suspend fun updateFisioterapeuta(fisioterapeuta: Fisioterapeuta)
}