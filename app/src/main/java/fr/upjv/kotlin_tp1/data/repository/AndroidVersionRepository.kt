package fr.upjv.kotlin_tp1.data.repository

import fr.upjv.kotlin_tp1.architecture.CustomApplication
import fr.upjv.kotlin_tp1.data.model.toDomain
import fr.upjv.kotlin_tp1.data.model.toRoomObject
import fr.upjv.kotlin_tp1.ui.model.AndroidObject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AndroidVersionRepository {


    private val androidVersionDao =
        CustomApplication.instance.mApplicationDatabase.androidVersionDao()


    fun selectAllAndroidVersion(): Flow<List<AndroidObject>> {
        return androidVersionDao.selectAll().map {
            it.toDomain()
        }
    }


    fun insertAndroidVersion(androidObject: AndroidObject) {
        androidVersionDao.insert(androidObject.toRoomObject())
    }


    fun deleteAllAndroidVersion() {
        androidVersionDao.deleteAll()
    }
}


