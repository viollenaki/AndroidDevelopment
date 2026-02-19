package com.example.mbank.data

import com.example.mbank.R
import com.example.mbank.data.model.PlaceCategory
import com.example.mbank.data.model.RecommendedPlace

class MyCityRepository {

    private val places = listOf(
        RecommendedPlace(
            id = 1,
            name = "City library",
            description = "A quiet and welcoming space for reading and studying.",
            address = "Abdrahmanova 233a",
            imageResource = R.drawable.library,
            category = PlaceCategory.BUILDINGS
        ),
        RecommendedPlace(
            id = 2,
            name = "Sunset at the Pier",
            description = "A scenic spot to enjoy the view of the harbor at sunset.",
            address = "Green City Beach",
            imageResource = R.drawable.great_view,
            category = PlaceCategory.BEACHES
        ),
        RecommendedPlace(
            id = 3,
            name = "City Theater",
            description = "A historic venue featuring live performances and cultural events.",
            address = "Abdrahmanova 156",
            imageResource = R.drawable.theater,
            category = PlaceCategory.BUILDINGS
        ),
        RecommendedPlace(
            id = 4,
            name = "Green City Pier",
            description = "A scenic waterfront location perfect for dining and enjoying the lake breeze.",
            address = "Green City Beach",
            imageResource = R.drawable.pier,
            category = PlaceCategory.BEACHES
        ),
        RecommendedPlace(
            id = 5,
            name = "Government Building",
            description = "Modern building with public services and administrative offices.",
            address = "Abdrahmanova 266",
            imageResource = R.drawable.gov_building,
            category = PlaceCategory.BUILDINGS
        ),
        RecommendedPlace(
            id = 6,
            name = "City Park",
            description = "A vibrant place for relaxation and outdoor activities.",
            address = "22 Lantern Street",
            imageResource = R.drawable.park,
            category = PlaceCategory.PARKS
        ),
        RecommendedPlace(
            id = 7,
            name = "Central Alley",
            description = "A quiet and charming alley with local shops and cafes.",
            address = "Central Alley",
            imageResource = R.drawable.alley,
            category = PlaceCategory.PARKS
        ),

    )

    fun getCategories(): List<PlaceCategory> = PlaceCategory.entries

    fun getPlacesByCategory(category: PlaceCategory): List<RecommendedPlace> {
        return places.filter { it.category == category }
    }

    fun getPlaceById(placeId: Int): RecommendedPlace? = places.find { it.id == placeId }
}
