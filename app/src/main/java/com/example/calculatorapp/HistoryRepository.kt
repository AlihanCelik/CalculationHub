package com.example.calculatorapp

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class HistoryRepository(private val database: HistoryDatabase) {

    val history: Flow<List<History>> = database.historyDatabaseDao.getHistory()

    suspend fun deleteHistory() {
        withContext(Dispatchers.IO) {
            database.historyDatabaseDao.deleteAll()
        }
    }

    suspend fun addCalculation(id: Int, input: String, output: String) {
        withContext(Dispatchers.IO) {
            val item = History(id, input, output)
            database.historyDatabaseDao.insert(item)
        }
    }



}