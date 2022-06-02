package ir.ehsan.instagramui.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ir.ehsan.instagramui.R

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimateView(visible:Boolean,content: @Composable ()->Unit) {
    Column {
        AnimatedVisibility(visible = visible, enter = scaleIn(tween(300)), exit = scaleOut(
            tween(300)
        )
        ) {
            content()
        }
    }
}