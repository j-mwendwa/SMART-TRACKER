package com.example.smarttracker.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.smarttracker.data.model.Expense
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao{
    @Query("SELECT *  FROM expenses ORDER BY date DESC")
    fun getAllExpenses () : Flow<List<Expense>>
    @Insert
    suspend fun insertExpense(expense: Expense)
    @Delete
    suspend fun deleteExpense(expense: Expense)

}