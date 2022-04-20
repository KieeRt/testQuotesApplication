package com.example.testapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.testapplication.roomdb.result.Converters

@Entity(tableName = "result")
data class Result(
    @PrimaryKey val _id: String,
    @ColumnInfo val author: String,
    @ColumnInfo val authorSlug: String,
    @ColumnInfo val content: String,
    @ColumnInfo val dateAdded: String,
    @ColumnInfo val dateModified: String,
    @ColumnInfo val length: Int,
    @TypeConverters(Converters::class)
    @ColumnInfo val tags: List<String>
){
    fun print(){
        println("_id:$_id")
        println("author:$author")
        println("authorslug:$authorSlug")
        println("content:$content")
        println("dateAdded:$dateAdded")
        println("dateModified:$dateModified")
        println("lenght:$length")
        println("tags:${tags.joinToString(separator = "") { "${it.toString()}\n" }} ")

    }

    override fun equals(other: Any?): Boolean {
        if(this === other) return true

        if(other is Result){
            val tmp : Result = other
            if(this._id == other._id) return true
        }

        return false
    }

    override fun hashCode(): Int {
        return this._id.toInt()
    }


}
