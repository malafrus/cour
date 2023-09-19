package fr.upjv.kotlin_tp1.data.repository

import fr.upjv.kotlin_tp1.architecture.CustomApplication
import fr.upjv.kotlin_tp1.architecture.RetrofitBuilder
import fr.upjv.kotlin_tp1.data.model.ChuckNorrisObject
import fr.upjv.kotlin_tp1.data.model.toDomain
import fr.upjv.kotlin_tp1.data.model.toRoom
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ChuckNorrisQuoteRepository {


    private val chuckNorrisDao = CustomApplication.instance.mApplicationDatabase.chuckNorrisDao()


    suspend fun fetchData() {
        chuckNorrisDao.insert(RetrofitBuilder.getChuckNorrisQuote().getRandomQuote().toRoom())
    }


    fun deleteAll() {
        chuckNorrisDao.deleteAll()
    }


    fun selectAll(): Flow<List<ChuckNorrisObject>> {
        return chuckNorrisDao.selectAll().map { list ->
            list.toDomain()
        }
    }
}
