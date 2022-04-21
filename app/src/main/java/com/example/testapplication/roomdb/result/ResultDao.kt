package com.example.testapplication.roomdb.result
import androidx.room.*
import com.example.testapplication.model.Result

@Dao
interface ResultDao {
    @Query("SELECT * FROM result")
    fun getAll(): List<Result>

    @Query("SELECT * FROM result WHERE _id = :id")
    fun findById(id : String) : Result

    @Query("SELECT * FROM result WHERE author = :author")
    fun findByAuthor(author: String) : List<Result>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(result: List<Result>)

    @Insert
    fun insert(result: Result)

    @Delete
    fun delete(result: Result)


}