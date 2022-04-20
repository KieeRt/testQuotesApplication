package com.example.testapplication.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testapplication.model.Result
import com.example.testapplication.model.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}