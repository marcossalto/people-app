package com.marcossalto.peopleapp.presentation.users.edit

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.marcossalto.peopleapp.R
import com.marcossalto.peopleapp.presentation.users.edit.components.EditBottomBar
import com.marcossalto.peopleapp.presentation.users.edit.components.EditContent
import com.marcossalto.peopleapp.presentation.users.edit.components.EditTopBar
import kotlinx.coroutines.flow.collectLatest

@Composable
fun EditScreen(
    navController: NavHostController,
    viewModel: EditViewModel = hiltViewModel(),
    navigateBack: () -> Unit
) {
    val nameState = viewModel.userName.value
    val lastNameState = viewModel.userLastName.value
    val ageState = viewModel.userAge.value

    val title = if (viewModel.currentUserId == null) {
        stringResource(id = R.string.add_user)
    } else {
        stringResource(id = R.string.update_user)
    }

    val textButton = if (viewModel.currentUserId == null) {
        stringResource(id = R.string.add)
    } else {
        stringResource(id = R.string.update)
    }

    val enabled = nameState.text.isNotEmpty() && lastNameState.text.isNotEmpty() && ageState.text.isNotEmpty()

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is EditViewModel.UiEvent.AddUser -> {
                    navController.navigateUp()
                }
            }
        }
    }

    Scaffold(
        topBar = {
            EditTopBar(
                topAppBarText = title,
                navigateBack = navigateBack
            )
        },
        content = { padding ->
            EditContent(
                padding = padding,
                name = nameState.text,
                lastName = lastNameState.text,
                age = ageState.text,
                onEvent = {
                    viewModel.onEvent(it)
                }
            )
        },
        bottomBar = {
            EditBottomBar(
                textButton = textButton,
                enabled = enabled,
                onAddUser = {
                    viewModel.onEvent(EditEvent.AddUser)
                }
            )
        }
    )
}
