package com.example.testapplication.roomdb.result
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.testapplication.model.Result

@Dao
interface ResultDao {
    @Query("SELECT * FROM result")
    fun getAll(): List<Result>

    @Query("SELECT * FROM result WHERE _id = :id")
    fun findById(id : Int)

    @Query("SELECT * FROM result WHERE author = :author")
    fun findByAuthor(author: String) : List<Result>

    @Insert
    fun insertAll(result: List<Result>)

    @Insert
    fun insert(result: Result)

    @Delete
    fun delete(result: Result)


}