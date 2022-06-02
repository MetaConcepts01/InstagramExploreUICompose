package ir.ehsan.instagramui.ui.components

import android.annotation.SuppressLint
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun FollowButton(following:Boolean,onClick:()->Unit) {
    Box(
        modifier = Modifier

            .clip(MaterialTheme.shapes.small)
            .border(0.5.dp, Color(0xFF4D4D4D), RoundedCornerShape(5.dp))
            .clickable {
                onClick()
            }
            .padding(horizontal = 8.dp, vertical = 4.dp)
            ,
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(visible = following, enter = scaleIn(tween(300)), exit = scaleOut(tween(300))) {
            Text(text = "Following", fontSize = 12.sp)
        }
        AnimatedVisibility(visible = !following, enter = scaleIn(tween(300)), exit = scaleOut(tween(300))) {
            Text(text = "Follow", fontSize = 12.sp)
        }
    }
}