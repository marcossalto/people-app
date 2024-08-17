package com.marcossalto.peopleapp.presentation.home.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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

@Composable
@Preview
fun HomeContentPreview() {
    HomeContent(
        onDeleteUser = {},
        onEditUser = {},
        users = listOf(
            User(id = 1, name = "John", lastName = "Doe", age = 30),
            User(id = 2, name = "Jane", lastName = "Doe", age = 25),
            User(id = 3, name = "Bob", lastName = "Smith", age = 40),
            User(id = 4, name = "Alice", lastName = "Johnson", age = 35),
            User(id = 5, name = "Tom", lastName = "Williams", age = 28),
            User(id = 6, name = "Sara", lastName = "Lee", age = 32),
            User(id = 7, name = "Mike", lastName = "Brown", age = 37),
            User(id = 8, name = "Emily", lastName = "Davis", age = 29),
            User(id = 9, name = "David", lastName = "Wilson", age = 42),
            User(id = 10, name = "Karen", lastName = "Taylor", age = 31)
        )
    )
}
