package fr.upjv.kotlin_tp1.ui.model

sealed interface ItemUi {

    data class Item(
        val versionNumber: String,
    ) : ItemUi


    data class Header(
        val title: String,
    ) : ItemUi

    data class Footer(
        val numberOfValues: Int,
    ) : ItemUi
}

fun List<AndroidObject>.toUi(): List<ItemUi.Item> {
    return map { currentAndroidObject ->
        ItemUi.Item(
            versionNumber = currentAndroidObject.versionNumber,
        )
    }
}
