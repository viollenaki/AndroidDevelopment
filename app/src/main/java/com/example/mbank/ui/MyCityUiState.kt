package com.example.mbank.ui

import com.example.mbank.data.model.PlaceCategory
import com.example.mbank.data.model.RecommendedPlace

data class MyCityUiState(
    val categories: List<PlaceCategory> = emptyList(),
    val selectedCategory: PlaceCategory? = null,
    val places: List<RecommendedPlace> = emptyList(),
    val selectedPlace: RecommendedPlace? = null,
    val categoryScrollIndex: Int = 0,
    val categoryScrollOffset: Int = 0,
    val placeScrollIndex: Int = 0,
    val placeScrollOffset: Int = 0
)
