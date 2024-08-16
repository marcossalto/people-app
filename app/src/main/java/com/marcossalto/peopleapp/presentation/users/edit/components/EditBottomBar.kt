package com.marcossalto.peopleapp.presentation.users.edit.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.marcossalto.peopleapp.R

@Composable
fun EditBottomBar(
    modifier: Modifier = Modifier,
    onAddUser: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 10.dp,
                vertical = 14.dp
            ),
        onClick = {
            onAddUser()
        }
    ) {
        Text(
            text = stringResource(id = R.string.add_user)
        )
    }
}
