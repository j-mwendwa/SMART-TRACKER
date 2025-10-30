package com.example.smarttracker.data.local

import android.app.Application
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.smarttracker.data.model.Expense

@Database(entities = [Expense ::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun expenseDAO(): ExpenseDao
}
