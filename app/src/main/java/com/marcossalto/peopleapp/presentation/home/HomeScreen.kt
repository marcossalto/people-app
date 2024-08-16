package com.marcossalto.peopleapp.presentation.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.marcossalto.peopleapp.presentation.Screen
import com.marcossalto.peopleapp.presentation.home.components.HomeContent
import com.marcossalto.peopleapp.presentation.home.components.HomeFab
import com.marcossalto.peopleapp.presentation.home.components.HomeTopBar

@Composable
fun HomeScreen(
    navController: androidx.navigation.NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.value

    Scaffold(
        topBar = {
            HomeTopBar()
        },
        content = { innerPadding ->
            HomeContent(
                modifier = Modifier
                    .padding(innerPadding),
                onDeleteUser = {
                    viewModel.onEvent(
                        event = HomeEvent.OnDeleteUser(it)
                    )
                },
                onEditUser = {
                    navController.navigate(
                        route = Screen.Edit.passId(it)
                    )
                },
                users = state.users
            )
        },
        floatingActionButton = {
            HomeFab(
                onFabClicked = {
                    navController.navigate(Screen.Edit.route)
                }
            )
        }
    )
}
