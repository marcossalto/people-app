package com.marcossalto.peopleapp.presentation.users.edit.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.marcossalto.peopleapp.R
import com.marcossalto.peopleapp.presentation.users.edit.EditEvent

@Composable
fun EditContent(
    padding: PaddingValues,
    name: String,
    lastName: String,
    age: String,
    onEvent: (EditEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        Spacer(
            modifier = Modifier
                .height(44.dp)
        )
        UserInputText(
            text = name,
            hint = stringResource(id = R.string.name),
            onTextChange = {
                onEvent(EditEvent.EnterName(it))
            }
        )
        UserInputText(
            text = lastName,
            hint = stringResource(id = R.string.last_name),
            onTextChange = {
                onEvent(EditEvent.EnterLastName(it))
            }
        )
        UserInputText(
            text = age,
            hint = stringResource(id = R.string.age),
            onTextChange = {
                onEvent(EditEvent.EnterAge(it))
            }
        )
    }
}
