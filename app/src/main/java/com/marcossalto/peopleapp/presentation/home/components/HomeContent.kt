package com.marcossalto.peopleapp.presentation.home.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.marcossalto.peopleapp.domain.model.User
import com.marcossalto.peopleapp.domain.repository.Users

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    onDeleteUser: (user: User) -> Unit,
    onEditUser: (id: Int?) -> Unit,
    users: Users = emptyList()
) {
    Surface(
        color = MaterialTheme.colorScheme.surface,
        modifier = modifier
    ) {
        LazyColumn {
            items(users) { user ->
                UserItem(
                    modifier = Modifier
                        .fillMaxSize(),
                    user = user,
                    onEditUser = {
                        onEditUser(user.id)
                    },
                    onDeleteUser = {
                        onDeleteUser(user)
                    }
                )
            }
        }
    }
}
