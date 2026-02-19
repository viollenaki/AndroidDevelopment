package com.example.mbank.ui

import androidx.lifecycle.ViewModel
import com.example.mbank.data.MyCityRepository
import com.example.mbank.data.model.PlaceCategory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MyCityViewModel(
    private val repository: MyCityRepository = MyCityRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow(
        MyCityUiState(
            categories = repository.getCategories()
        )
    )
    val uiState: StateFlow<MyCityUiState> = _uiState.asStateFlow()

    init {
        val defaultCategory = repository.getCategories().firstOrNull()
        if (defaultCategory != null) {
            selectCategory(defaultCategory)
        }
    }

    fun selectCategory(category: PlaceCategory) {
        _uiState.update {
            it.copy(
                selectedCategory = category,
                places = repository.getPlacesByCategory(category),
                selectedPlace = null
            )
        }
    }

    fun selectPlace(placeId: Int) {
        _uiState.update {
            it.copy(selectedPlace = repository.getPlaceById(placeId))
        }
    }

    fun updateCategoryScroll(index: Int, offset: Int) {
        _uiState.update {
            it.copy(
                categoryScrollIndex = index,
                categoryScrollOffset = offset
            )
        }
    }

    fun updatePlaceScroll(index: Int, offset: Int) {
        _uiState.update {
            it.copy(
                placeScrollIndex = index,
                placeScrollOffset = offset
            )
        }
    }

    fun resolveCategory(categoryName: String): PlaceCategory? {
        return repository.getCategories().firstOrNull { it.name == categoryName }
    }
}
