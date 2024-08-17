package com.marcossalto.peopleapp.presentation.home.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.marcossalto.peopleapp.core.toHslColor
import com.marcossalto.peopleapp.domain.model.User

@Composable
fun Avatar(
    user: User,
    modifier: Modifier = Modifier,
    size: Dp = 56.dp,
    textStyle: TextStyle = MaterialTheme.typography.headlineSmall,
) {
    Box(
        modifier = modifier
            .size(size),
        contentAlignment = Alignment.Center
    ) {
        val color = remember(user) {
            val name = listOf(user.name, user.lastName)
                .joinToString(separator = "")
                .uppercase()
            Color("${user.id} / $name".toHslColor())
        }
        val initials = (user.name.take(1) + user.lastName.take(1)).uppercase()

        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight()
        ) {
            drawCircle(
                brush = SolidColor(color)
            )
        }
        Text(
            text = initials,
            style = textStyle,
            color = Color.White
        )
    }
}

@Composable
@Preview
fun AvatarPreview() {
    Avatar(
        user = User(id = 1, name = "John", lastName = "Doe", age = 30)
    )
}
