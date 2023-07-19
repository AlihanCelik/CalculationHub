package com.example.calculatorapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(historyItem: History)

    @Query("SELECT * FROM calculator_history_table")
    fun getHistory(): Flow<List<History>>

    @Query("DELETE FROM calculator_history_table")
    suspend fun deleteAll()
}