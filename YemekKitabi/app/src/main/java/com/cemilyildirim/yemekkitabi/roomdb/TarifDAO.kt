package com.cemilyildirim.yemekkitabi.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.cemilyildirim.yemekkitabi.model.Tarif

@Dao
interface TarifDAO {

    @Query("SELECT * FROM tarif")
    fun getAll() : List<Tarif>

    @Query("SELECT * FROM tarif WHERE id = :id")
    fun findById(id : Int) : Tarif

    @Insert
    fun insert(tarif : Tarif)

    @Delete
    fun delete(tarif : Tarif)
}