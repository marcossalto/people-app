package com.marcossalto.peopleapp.presentation.users.edit.components

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.layout.LayoutModifier
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp

data class BaseLineHeightModifier(
    val heightFromBaseLine: Dp
) : LayoutModifier {
    override fun MeasureScope.measure(
        measurable: Measurable,
        constraints: Constraints
    ): MeasureResult {
        val textPlaceable = measurable.measure(constraints)
        val firstBaseline = textPlaceable[FirstBaseline]
        val lastBaseline = textPlaceable[LastBaseline]
        val height = heightFromBaseLine.roundToPx() + lastBaseline - firstBaseline

        return layout(constraints.maxWidth, height) {
            val topY = heightFromBaseLine.roundToPx() - firstBaseline
            textPlaceable.place(0, topY)
        }
    }
}

fun Modifier.baseLineHeight(heightFromBaseLine: Dp): Modifier =
    this.then(
        BaseLineHeightModifier(heightFromBaseLine)
    )
