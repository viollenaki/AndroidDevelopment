package com.example.mbank.navigation

sealed interface MyCityDestination {
    val route: String

    data object Categories : MyCityDestination {
        override val route: String = "categories"
    }

    data object Places : MyCityDestination {
        override val route: String = "places/{category}"
        fun createRoute(category: String): String = "places/$category"
    }

    data object Details : MyCityDestination {
        override val route: String = "details/{placeId}"
        fun createRoute(placeId: Int): String = "details/$placeId"
    }
}
