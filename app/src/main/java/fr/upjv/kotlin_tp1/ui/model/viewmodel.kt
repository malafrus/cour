package fr.upjv.kotlin_tp1.ui.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.upjv.kotlin_tp1.data.repository.AndroidVersionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlin.random.Random

class AndroidVersionViewModel : ViewModel() {


    private val androidVersionRepository: AndroidVersionRepository by lazy { AndroidVersionRepository() }


    private val _androidVersionList: Flow<List<ItemUi>>
        get() = androidVersionRepository.selectAllAndroidVersion().map { androidObjectList ->
            androidObjectList.groupBy { myAndroidObject ->
                myAndroidObject.versionName
            } // map <String, List<MyAndroidObject>>
                .flatMap {
                    buildList {
                        add(ItemUi.Header(
                            title = it.key,// versionName
                        ))
                        addAll(it.value.toUi()) // List of android version number for the given name
                        add(ItemUi.Footer(
                            numberOfValues = it.value.size,
                        ))
                    }
                }
        }
    // On rend accessible uniquement en lecture la valeur de la variable mutable afin de bloquer l'accès
    val androidVersionList = _androidVersionList


    fun insertAndroidVersion() {
        viewModelScope.launch(Dispatchers.IO) {
            val random = Random.nextInt(0, 10)
            androidVersionRepository.insertAndroidVersion(
                AndroidObject("Android $random", "$random")
            )
        }
    }


    fun deleteAllAndroidVersion() {
        viewModelScope.launch(Dispatchers.IO) {
            androidVersionRepository.deleteAllAndroidVersion()
        }
    }
}

