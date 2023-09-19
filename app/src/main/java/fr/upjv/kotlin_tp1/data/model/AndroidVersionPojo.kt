package fr.upjv.kotlin_tp1.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import fr.upjv.kotlin_tp1.ui.model.AndroidObject

@Entity(tableName = "android_version_object_table")
data class AndroidVersionPojo(

    @ColumnInfo(name = "name")
    val name: String,


    @ColumnInfo(name = "code")
    val code: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

fun AndroidObject.toRoomObject(): AndroidVersionPojo {
    return AndroidVersionPojo(
        name = versionName,
        code = versionNumber,
    )
}


fun List<AndroidVersionPojo>.toDomain(): List<AndroidObject> {
    return map { eachItem ->
        AndroidObject(
            versionNumber = eachItem.code,
            versionName = eachItem.name,
        )
    }
}

