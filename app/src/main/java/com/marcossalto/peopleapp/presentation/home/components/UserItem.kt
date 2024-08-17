package com.marcossalto.peopleapp.presentation.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
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
            .padding(
                horizontal = 8.dp,
                vertical = 8.dp
            ),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(
            corner = CornerSize(16.dp)
        ),
        onClick = onEditUser
    ) {
        ConstraintLayout(
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentSize()
                .fillMaxWidth()
                .padding(8.dp)
                .drawBehind { drawRect(color = Color.Transparent) }

        ) {
            val (avatar, name, age, delete) = createRefs()
            Avatar(
                user = user,
                modifier = Modifier
                    .constrainAs(avatar) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                    }
                    .padding(8.dp)
            )

            BasicText(
                modifier = Modifier
                    .constrainAs(name) {
                        start.linkTo(avatar.end)
                        top.linkTo(avatar.top)
                        end.linkTo(delete.start)
                        width = Dimension.fillToConstraints
                    }
                    .padding(8.dp),
                text = "${user.name}, ${user.lastName}",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.headlineSmall
            )

            BasicText(
                modifier = Modifier
                    .constrainAs(age) {
                        start.linkTo(name.start)
                        top.linkTo(name.bottom)

                    }
                    .padding(start = 8.dp, bottom = 8.dp),
                text = user.age.toString(),
                style = MaterialTheme.typography.bodyLarge.copy(color = Color.Black)
            )
            IconButton(
                modifier = Modifier.constrainAs(delete) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                },
                onClick = onDeleteUser
            ) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
@Preview
fun UserItemPreview() {
    UserItem(
        modifier = Modifier,
        user = User(id = 1, name = "John", lastName = "Doe", age = 30),
        onEditUser = {},
        onDeleteUser = {}
    )
}
