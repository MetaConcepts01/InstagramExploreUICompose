package ir.ehsan.instagramui.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.glide.GlideImage
import ir.ehsan.instagramui.R
import ir.ehsan.instagramui.ui.Post

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Post(
    post: Post,
    isFollowing: (Int) -> Boolean,
    isLiked: (Int) -> Boolean,
    onFollow: (Int) -> Unit,
    onLike:(Int)->Unit,
    isBookmarked:(Int)->Boolean,
    onBookmark:(Int)->Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 6.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(modifier = Modifier.clip(CircleShape), contentAlignment = Alignment.Center) {
                    GlideImage(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape),
                        imageModel = post.owner.profile,
                        contentDescription = post.owner.name
                    )
                    GlideImage(modifier = Modifier.size(50.dp), imageModel = R.drawable.story)
                }
                Text(
                    text = post.owner.name,
                    fontSize = 12.sp,
                    style = TextStyle(fontWeight = FontWeight.Bold)
                )
            }
            FollowButton(following = isFollowing(post.owner.id), onClick = {
                onFollow(post.owner.id)
            })
        }
        Box(contentAlignment = Alignment.Center){
            GlideImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .sizeIn(maxHeight = 450.dp)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onDoubleTap = {
                                onLike(post.id)
                            }
                        )
                    },
                imageModel = post.img,
                contentScale = ContentScale.Crop,
                loading = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(450.dp), contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator(
                            strokeWidth = 1.dp,
                            color = MaterialTheme.colors.onBackground
                        )
                    }
                }
            )
            Column {
                val dumpAnimation: FiniteAnimationSpec<Float> = spring(
                    dampingRatio = 0.3f,
                    stiffness = Spring.StiffnessLow
                )
                AnimatedVisibility(visible = post.likeAnim, enter = scaleIn(dumpAnimation), exit = scaleOut(
                    tween(500))) {
                    Icon(painter = painterResource(id = R.drawable.ic_heart), contentDescription = null,tint=Color.White,modifier=Modifier.size(100.dp))
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 20.dp, start = 20.dp, top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(18.dp)) {
                Column {
                    Spacer(modifier = Modifier.height(4.dp))
                    Box {
                        AnimateView(visible = !isLiked(post.id)) {
                            Icon(
                                modifier = Modifier.size(25.dp),
                                painter = painterResource(id = R.drawable.ic_heart_outlined),
                                contentDescription = "Like",
                                tint = MaterialTheme.colors.onBackground
                            )
                        }

                        AnimateView(visible = isLiked(post.id)) {
                            Icon(
                                modifier = Modifier.size(25.dp),
                                painter = painterResource(id = R.drawable.ic_heart),
                                contentDescription = "Like",
                                tint = Color(0xFFF04343)
                            )
                        }
                    }
                }
                Column {
                    Spacer(modifier = Modifier.height(5.dp))
                    Icon(
                        modifier = Modifier.size(25.dp),
                        painter = painterResource(id = R.drawable.ic_comment),
                        contentDescription = "Comment",
                        tint = MaterialTheme.colors.onBackground
                    )
                }
                Icon(
                    modifier = Modifier
                        .size(25.dp)
                        .rotate(-30f),
                    painter = painterResource(id = R.drawable.ic_send),
                    contentDescription = "Send",
                    tint = MaterialTheme.colors.onBackground
                )
            }
            Column {
                Spacer(modifier = Modifier.height(4.dp))
                Box{
                    AnimateView(visible = !isBookmarked(post.id)) {
                        Icon(
                            modifier = Modifier.size(25.dp).clickable(
                                onClick = {
                                    onBookmark(post.id)
                                },
                                indication = null,
                                interactionSource = remember {
                                    MutableInteractionSource()
                                }
                            ),
                            painter = painterResource(id = R.drawable.ic_bookmark_outlined),
                            contentDescription = "Bookmark",
                            tint = MaterialTheme.colors.onBackground
                        )
                    }
                    AnimateView(visible = isBookmarked(post.id)) {
                        Icon(
                            modifier = Modifier.size(25.dp),
                            painter = painterResource(id = R.drawable.ic_bookmark),
                            contentDescription = "Bookmark",
                            tint = MaterialTheme.colors.onBackground
                        )
                    }
                }
            }
        }
        Column(Modifier.padding(top = 8.dp, end = 20.dp, start = 20.dp)) {
            Text(
                text = "${"%,d".format(post.likes)} likes",
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "${post.owner.name} ${post.description}",
                color = MaterialTheme.colors.onBackground,
                fontSize = 13.sp
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = post.time, color = Color(0xFF4D4D4D), fontSize = 11.sp)
        }

    }
}