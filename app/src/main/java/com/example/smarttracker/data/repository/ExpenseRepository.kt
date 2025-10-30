package com.example.smarttracker.data.repository

import com.example.smarttracker.data.local.ExpenseDao
import com.example.smarttracker.data.model.Expense

class ExpenseRepository(private val dao: ExpenseDao){
    fun getExpenses() =dao.getAllExpenses()
    suspend fun addExpense(expense: Expense) = dao.insertExpense(expense)
    suspend fun deleteExpense(expense: Expense) = dao.deleteExpense(expense)

}