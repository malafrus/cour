package fr.upjv.kotlin_tp1.ui.model

import fr.upjv.kotlin_tp1.data.model.ChuckNorrisObject


data class ChuckItemUi(
    val quote: String,
    val iconUrl: String,
)


fun List<ChuckNorrisObject>.toUi() : List<ChuckItemUi> {
    return map { item ->
        ChuckItemUi(
            quote = item.title,
            iconUrl = item.url,
        )
    }
}
