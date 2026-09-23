package com.fel.week2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fel.week2.ui.theme.Week2VPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week2VPTheme {
                MusicDisplayScreen()
            }
        }
    }
}

@Composable
fun MusicDisplayScreen() {
    val backgroundColor = Color(0xFFFFA0A0)
    val darkCardColor = Color(0xFF330909)

    var isLiked by remember { mutableStateOf(value = true) }
    var isPlaying by remember { mutableStateOf(value = true) }
    var sliderPosition by remember { mutableFloatStateOf(value = 0.12f) }

    val lyricsText = """
        Watch this, watch this beat goin'
        hooligan
        We pop out, we actin' a fool again
        
        Step in the room, feel the atmosphere shift
        Catching the wave, yeah you know it's a gift
        Turn up the sound, let the bassline hit
        Every single second, yeah we makin' it fit
        
        Watch this, watch this beat goin'
        hooligan
        We pop out, we actin' a fool again
        
        Running through the city with the lights down low
        Never gotta ask 'cause you already know
        Living for the rhythm, taking control
        Music in the spirit, fire in the soul
        
        Watch this, watch this beat goin'
        hooligan
        We pop out, we actin' a fool again
        
        From the top of the world to the end of the line
        Every single moment is a design
        We don't stop, we don't slow down
        Turn the volume up, we own this town!
        
        Watch this, watch this beat goin'
        hooligan
        We pop out, we actin' a fool again
    """.trimIndent()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = backgroundColor,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .padding(top = 40.dp, bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // Top Navigation Bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_chevron_down),
                        contentDescription = "Collapse",
                        tint = Color.Black,
                    )
                }

                Text(
                    text = "Liked Songs",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )

                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_more_dots),
                        contentDescription = "More Options",
                        tint = Color.Black,
                    )
                }
            }

            // Album Cover
            val albumShape = RoundedCornerShape(16.dp)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .aspectRatio(1f)
                    .border(width = 3.dp, color = Color.White, shape = albumShape),
                shape = albumShape,
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            ) {
                Image(
                    painter = painterResource(id = R.drawable.album_cover),
                    contentDescription = "Album Cover",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop,
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Song Title & Artist + Favorite Icon
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column {
                    Text(
                        text = "Hooligan",
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "BTS",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black.copy(alpha = 0.8f),
                    )
                }

                IconButton(onClick = { isLiked = !isLiked }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_heart_filled),
                        contentDescription = "Liked",
                        tint = if (isLiked) Color.Black else Color.Gray,
                        modifier = Modifier.size(32.dp),
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Progress Slider & Timestamps
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
            ) {
                Slider(
                    value = sliderPosition,
                    onValueChange = { sliderPosition = it },
                    valueRange = 0f..1f,
                    colors = SliderDefaults.colors(
                        thumbColor = Color.Black,
                        activeTrackColor = Color.Black,
                        inactiveTrackColor = Color.Black.copy(alpha = 0.2f),
                    ),
                    modifier = Modifier.fillMaxWidth(),
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "0:12",
                        fontSize = 14.sp,
                        color = Color.Black,
                    )
                    Text(
                        text = "-2:14",
                        fontSize = 14.sp,
                        color = Color.Black,
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Playback Controls
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(
                    onClick = { },
                    modifier = Modifier.size(48.dp),
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_skip_previous),
                        contentDescription = "Previous Track",
                        tint = Color.Black,
                        modifier = Modifier.size(36.dp),
                    )
                }

                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .background(Color.Black),
                    contentAlignment = Alignment.Center,
                ) {
                    IconButton(onClick = { isPlaying = !isPlaying }) {
                        Icon(
                            painter = painterResource(
                                id = if (isPlaying) R.drawable.ic_pause else R.drawable.ic_play,
                            ),
                            contentDescription = if (isPlaying) "Pause" else "Play",
                            tint = Color.White,
                            modifier = Modifier.size(28.dp),
                        )
                    }
                }

                IconButton(
                    onClick = { },
                    modifier = Modifier.size(48.dp),
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_skip_next),
                        contentDescription = "Next Track",
                        tint = Color.Black,
                        modifier = Modifier.size(36.dp),
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Scrollable Lyrics Card
            val lyricsShape = RoundedCornerShape(24.dp)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                shape = lyricsShape,
                colors = CardDefaults.cardColors(containerColor = darkCardColor),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                ) {
                    Text(
                        text = "Lyrics",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState()),
                    ) {
                        Text(
                            text = lyricsText,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color.White,
                            lineHeight = 24.sp,
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MusicDisplayScreenPreview() {
    Week2VPTheme {
        MusicDisplayScreen()
    }
}
