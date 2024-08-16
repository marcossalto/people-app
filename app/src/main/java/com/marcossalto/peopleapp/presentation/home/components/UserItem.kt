package com.marcossalto.peopleapp.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.marcossalto.peopleapp.domain.model.User

@Composable
fun UserItem(
    modifier: Modifier,
    user: User,
    onEditUser: () -> Unit,
    onDeleteUser: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(
            corner = CornerSize(16.dp)
        )
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "${user.name}, ${user.lastName}",
                style = MaterialTheme.typography.headlineMedium,
            )
            Spacer(
                modifier = Modifier
                    .height(4.dp)
            )
            Text(
                text = user.age.toString(),
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.DarkGray)
            )
        }
        Row {
            IconButton(onClick = onEditUser) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = null,
                    tint = Color.Green
                )
            }
            IconButton(onClick = onDeleteUser) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = null,
                    tint = Color.Red
                )
            }
        }
    }
}
