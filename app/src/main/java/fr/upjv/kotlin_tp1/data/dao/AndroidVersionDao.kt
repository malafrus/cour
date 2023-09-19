package fr.upjv.kotlin_tp1.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.upjv.kotlin_tp1.data.model.AndroidVersionPojo
import kotlinx.coroutines.flow.Flow

@Dao
interface AndroidVersionDao {

    @Query("SELECT * FROM android_version_object_table ORDER BY name ASC")
    fun selectAll(): Flow<List<AndroidVersionPojo>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(androidVersion: AndroidVersionPojo)


    @Query("DELETE FROM android_version_object_table")
    fun deleteAll()
}
