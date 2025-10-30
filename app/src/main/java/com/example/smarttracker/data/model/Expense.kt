package com.example.smarttracker.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.temporal.TemporalAmount


@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true)
    val id : Int =0,
    val title: String,
    val category: String,
    val amount: Double,
    val date: Long
)