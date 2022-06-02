package ir.ehsan.instagramui.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import ir.ehsan.instagramui.ui.components.Post
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun App() {
    Column(Modifier.fillMaxSize()) {
        val posts = remember {
            mutableStateListOf(
                Post(
                    id=1,
                    owner = User(
                        id = 1,
                        name = "Ehsan.MX",
                        profile = "https://1.bp.blogspot.com/-NiNaLUVIuaE/XdP7uYpCD_I/AAAAAAAAbu8/j1n9UFpof_QqchUqFqJO2ZNcu6wRToLpwCLcBGAsYHQ/s16000-rw/24%2BHearts%2BDP%2BProfile%2BPictures%2Bcollection%2B2019%2B-facebookdp%2B%252817%2529.jpg"
                    ),
                    img = "https://media.cntraveler.com/photos/5ea9df878abbf81d02aeae0b/4:5/w_3212,h_4015,c_limit/Kawachi-Fuji-Garden-wisteria-GettyImages-684691336.jpg",
                    description = "گل های استان چابهار، چابهار انصافا یکی از زیباترین جاهاس توصیه میکنم حتما بازدید کنین",
                    likes = 783,
                    time = "53 minutes ago"
                ),
                Post(
                    id=2,
                    owner = User(
                        id = 2,
                        name = "Ali.879",
                        profile = "https://data.whicdn.com/images/339581930/original.jpg"
                    ),
                    img = "https://statusprince.com/Categories/DP_For_Boys/DP_For_Boys_320139434.jpg",
                    description = "چطور شده؟ اینور جلوی خونه قدیمی مادربزرگم انداختم، فوت کردن البته تقریبا سال پیش بود \uD83D\uDE1E",
                    likes = 9912,
                    time = "1 day ago"
                ),
                Post(
                    id=3,
                    owner = User(
                        id = 3,
                        name = "MT.Reza",
                        profile = "https://res.cloudinary.com/twenty20/private_images/t_watermark-criss-cross-10/v1609839409000/photosp/83c5d322-a055-42e6-ae84-3e377b60bbb2/stock-photo-happy-boy-handsome-guy-stylish-boy-attitude-boy-fashionable-boy-cool-guys-of-india-selfie-profile-photo-selfie-profile-photo-image-of-the-year-83c5d322-a055-42e6-ae84-3e377b60bbb2.jpg"
                    ),
                    img = "https://cdn.nody.ir/files/2021/08/30/nody-%D8%B9%DA%A9%D8%B3-%D9%85%D9%81%D9%87%D9%88%D9%85%DB%8C-%DA%86%D8%A7%DB%8C-1630332765.jpg",
                    description = "امروز اومدم یه سر به مادر بزرگم بزنم، بنده خدا پدربزرگم فوت کرده تو خونه تنهاست \uD83D\uDE05",
                    likes = 51,
                    time = "5 hours ago"
                ),
                Post(
                    id=4,
                    owner = User(
                        id = 4,
                        name = "Mohammad.81",
                        profile = "https://static-prod.adweek.com/wp-content/uploads/2020/12/HackerBlackHoodieNeonMaskSmartphone.jpg"
                    ),
                    img = "https://i.pinimg.com/originals/07/85/ee/0785ee4ef06fc98d74356e5e150fb7c2.jpg",
                    description = "با بچه ها اومدیم شمال، انصافا جای زیباییه ولی مردم طبیعت رو با اشغال هاشون گند زدن متاسفانه \uD83D\uDE15",
                    likes = 1059,
                    time = "32 minutes ago"
                ),
                Post(
                    id=5,
                    owner = User(
                        id = 5,
                        name = "Saraw.74",
                        profile = "https://zhaviz.com/wp-content/uploads/2022/02/ax-profile-dokhtare-maqbool-1.jpg"
                    ),
                    img = "http://axneveshteh.ir/wp-content/uploads/2020/01/%D8%B9%DA%A9%D8%B3-%D9%BE%D8%B1%D9%88%D9%81%D8%A7%DB%8C%D9%84-%D8%AC%D8%AF%DB%8C%D8%AF-%D8%AF%D8%AE%D8%AA%D8%B1-%D8%AA%D9%86%D9%87%D8%A7-%D9%88-%D8%BA%D9%85%DA%AF%DB%8C%D9%86-%D9%88-%D9%86%D8%A7%D8%B1%D8%A7%D8%AD%D8%AA-%D8%A8%D8%B1%D8%A7%DB%8C-%D9%BE%D8%B1%D9%88%D9%81%D8%A7%DB%8C%D9%84-65.jpg",
                    description = "باید بگم اصفهان یکی از بهترین جا های دیدنی کشوره!",
                    likes = 5647,
                    time = "9 hours ago"
                ),
                Post(
                    id=6,
                    owner = User(
                        id = 6,
                        name = "Mohadese.at2",
                        profile = "https://mag.noorgram.ir/wp-content/uploads/2020/10/%D8%B9%DA%A9%D8%B3-%D8%AF%D8%AE%D8%AA%D8%B1-%D8%A8%D8%B1%D8%A7%DB%8C-%D9%BE%D8%B1%D9%88%D9%81%D8%A7%DB%8C%D9%84.jpg"
                    ),
                    img = "http://admin.rasekhoon.net/_files/userfiles//news/1391/picture/motafareghe1/%D8%A7%D9%83%D8%B3%D9%81%D9%88%D8%B1%D8%AF.jpg",
                    description = "دانشگاه هاروارد، اخه چقدر دانشگاه زیباییه :)",
                    likes = 9001,
                    time = "6 hours ago"
                ),
            )
        }

        val listOfFollowings = remember {
            mutableStateListOf<Int>()
        }
        val listOfLikes = remember {
            mutableStateListOf<Int>()
        }
        val listOfBookmarks = remember {
            mutableStateListOf<Int>()
        }

        val scope = rememberCoroutineScope()
        LazyColumn{
            items(posts){
                Post(
                    post = it,
                    isFollowing = { userId->
                        userId in listOfFollowings
                    },
                    onFollow = { userId->
                        if (userId !in listOfFollowings){
                            listOfFollowings.add(userId)
                        }
                    },
                    isLiked = { postId->
                        postId in listOfLikes
                    },
                    onLike = { postId->
                        scope.launch {
                            val findIndex = posts.indexOf(posts.find { it.id == postId })
                            posts[findIndex] = posts[findIndex].copy(likeAnim = true)
                            if (postId !in listOfLikes){
                                listOfLikes.add(postId)
                            }
                            delay(1500)
                            posts[findIndex] = posts[findIndex].copy(likeAnim = false)

                        }
                    },
                    isBookmarked = { postId->
                        postId in listOfBookmarks
                    },
                    onBookmark = { postId->
                        if (postId !in listOfBookmarks){
                            listOfBookmarks.add(postId)
                        }
                    }
                )
            }
        }
    }
}



data class Post(
    val id:Int,
    val owner:User,
    val img:String,
    val description:String,
    val likes:Int,
    val time:String,
    val liked:Boolean = false,
    val likeAnim:Boolean = false,
)
data class User(
    val id:Int,
    val name:String,
    val profile:String
)