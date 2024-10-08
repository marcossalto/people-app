package com.marcossalto.peopleapp.presentation.users.edit.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marcossalto.peopleapp.R
import kotlin.reflect.typeOf

@Composable
fun UserInputText(
    text: String,
    hint: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            )
    ) {
        Text(
            text = hint,
            modifier = Modifier.baseLineHeight(28.dp),
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.sf_pro_text_regular)),
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                lineHeight = 16.sp,
                letterSpacing = 0.4.sp
            ),
            color = Color.Black
        )
        BasicTextField(
            modifier = Modifier.baseLineHeight(28.dp),
            value = text,
            singleLine = true,
            onValueChange = onTextChange,
            textStyle = TextStyle(
                fontFamily = FontFamily(Font(R.font.sf_pro_text_regular)),
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                letterSpacing = 0.15.sp
            )
        )
        HorizontalDivider(
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}
