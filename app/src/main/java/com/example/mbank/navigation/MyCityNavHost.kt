package com.example.mbank.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mbank.ui.MyCityViewModel
import com.example.mbank.ui.screens.CategoryListScreen
import com.example.mbank.ui.screens.PlaceDetailsScreen
import com.example.mbank.ui.screens.PlaceListScreen

@Composable
fun MyCityNavHost(
    viewModel: MyCityViewModel = viewModel()
) {
    val navController = rememberNavController()
    val uiState by viewModel.uiState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = MyCityDestination.Categories.route
    ) {
        composable(route = MyCityDestination.Categories.route) {
            CategoryListScreen(
                categories = uiState.categories,
                selectedCategory = uiState.selectedCategory,
                initialScrollIndex = uiState.categoryScrollIndex,
                initialScrollOffset = uiState.categoryScrollOffset,
                onScrollChanged = viewModel::updateCategoryScroll,
                onCategoryClick = { category ->
                    viewModel.selectCategory(category)
                    navController.navigate(MyCityDestination.Places.createRoute(category.name))
                }
            )
        }

        composable(
            route = MyCityDestination.Places.route,
            arguments = listOf(navArgument("category") { type = NavType.StringType })
        ) { backStackEntry ->
            val categoryName = backStackEntry.arguments?.getString("category")
            val category = categoryName?.let(viewModel::resolveCategory)
            if (category != null && uiState.selectedCategory != category) {
                viewModel.selectCategory(category)
            }

            PlaceListScreen(
                categoryTitle = category?.title ?: "Places",
                places = uiState.places,
                initialScrollIndex = uiState.placeScrollIndex,
                initialScrollOffset = uiState.placeScrollOffset,
                onBackClick = { navController.popBackStack() },
                onPlaceClick = { placeId ->
                    viewModel.selectPlace(placeId)
                    navController.navigate(MyCityDestination.Details.createRoute(placeId))
                },
                onScrollChanged = viewModel::updatePlaceScroll
            )
        }

        composable(
            route = MyCityDestination.Details.route,
            arguments = listOf(navArgument("placeId") { type = NavType.IntType })
        ) { backStackEntry ->
            val placeId = backStackEntry.arguments?.getInt("placeId")
            if (placeId != null) {
                viewModel.selectPlace(placeId)
            }

            PlaceDetailsScreen(
                place = uiState.selectedPlace,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
