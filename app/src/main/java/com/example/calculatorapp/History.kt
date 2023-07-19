package com.example.calculatorapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "calculator_history_table")
data class History(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "input")
    val inputString: String,
    @ColumnInfo(name = "output")
    val outputString: String
)
