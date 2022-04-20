package com.example.testapplication.roomdb.result

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testapplication.model.Result

@Database(entities = [Result::class], version = 1)


abstract class ResultDatabase : RoomDatabase() {
}