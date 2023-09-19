package fr.upjv.kotlin_tp1.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.upjv.kotlin_tp1.data.dao.AndroidVersionDao
import fr.upjv.kotlin_tp1.data.dao.ChuckNorrisDao
import fr.upjv.kotlin_tp1.data.model.AndroidVersionPojo
import fr.upjv.kotlin_tp1.data.model.ChuckNorrisEntity

@Database(
    entities = [
        AndroidVersionPojo::class,
        ChuckNorrisEntity::class
    ],
    version = 2,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {

    abstract fun androidVersionDao(): AndroidVersionDao

    abstract fun chuckNorrisDao(): ChuckNorrisDao
}


