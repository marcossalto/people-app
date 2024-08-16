package com.marcossalto.peopleapp.presentation.users.edit.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.marcossalto.peopleapp.R

@Composable
fun EditBottomBar(
    modifier: Modifier = Modifier,
    enabled: Boolean = false,
    onAddUser: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = 20.dp,
                vertical = 32.dp,
            )
            .height(48.dp),
        onClick = {
            onAddUser()
        },
        enabled = enabled
    ) {
        Text(
            text = stringResource(id = R.string.add_user)
        )
    }
}
