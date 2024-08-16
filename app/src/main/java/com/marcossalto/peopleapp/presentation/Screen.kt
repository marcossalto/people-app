package com.marcossalto.peopleapp.presentation

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object Edit : Screen("edit?userId={userId}") {
        fun passId(userId: Int?): String {
            return "edit?userId=$userId"
        }
    }
}
