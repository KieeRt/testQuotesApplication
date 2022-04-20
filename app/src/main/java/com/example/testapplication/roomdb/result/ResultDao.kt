package com.example.testapplication.roomdb.result
import androidx.room.Dao
import androidx.room.Query
import com.example.testapplication.model.Result

@Dao
interface ResultDao {
    @Query("SELECT * FROM result")
    fun getAll(): List<Result>

}