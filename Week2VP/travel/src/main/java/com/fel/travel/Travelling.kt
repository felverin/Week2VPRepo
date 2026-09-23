package com.fel.travel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fel.travel.ui.theme.Week2VPTheme

val Poppins = FontFamily(
    Font(resId = R.font.poppins_regular, weight = FontWeight.Normal),
    Font(resId = R.font.poppins_medium, weight = FontWeight.Medium),
    Font(resId = R.font.poppins_bold, weight = FontWeight.Bold),
)

class Travelling : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week2VPTheme {
                DisplayScreen()
            }
        }
    }
}

@Composable
fun DisplayScreen() {
    val cardBackgroundColor = Color(0xFF333752)
    val inputFieldColor = Color(0xFFD8E8FC)
    val inputTextColor = Color(0xFF4A5568)
    val starColor = Color(0xFFFFC107)

    var answer1 by remember { mutableStateOf(value = "") }
    var answer2 by remember { mutableStateOf(value = "") }
    var answer3 by remember { mutableStateOf(value = "") }

    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
        ) {
            // Background Image
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription = "Aurora Background",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )

            // Bottom Card Container
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(top =300.dp),
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                colors = CardDefaults.cardColors(containerColor = cardBackgroundColor),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        Text(
                            text = "My Travel",
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = Poppins,
                            color = Color.White,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 12.dp),
                            textAlign = TextAlign.Center,
                        )

                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Aurora",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = Poppins,
                            color = Color.White,
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        // Location: "Tromsø, Norway"
                        Text(
                            text = "Tromsø, Norway",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            fontFamily = Poppins,
                            color = Color.White.copy(alpha = 0.85f),
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        // Rating Stars & Score (5.0)
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp),
                        ) {
                            repeat(times = 5) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_star),
                                    contentDescription = "Star",
                                    tint = starColor,
                                    modifier = Modifier.size(20.dp),
                                )
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = "5.0",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                fontFamily = Poppins,
                                color = starColor,
                            )
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        // Question Input Fields
                        TravelInputField(
                            value = answer1,
                            onValueChange = { answer1 = it },
                            placeholderText = "What did you enjoy most about your trip?",
                            backgroundColor = inputFieldColor,
                            textColor = inputTextColor,
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        TravelInputField(
                            value = answer2,
                            onValueChange = { answer2 = it },
                            placeholderText = "What was your favorite spot?",
                            backgroundColor = inputFieldColor,
                            textColor = inputTextColor,
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        TravelInputField(
                            value = answer3,
                            onValueChange = { answer3 = it },
                            placeholderText = "Anything else you'd like to add?",
                            backgroundColor = inputFieldColor,
                            textColor = inputTextColor,
                        )
                    }

                    // Floating Action Plus Button (Matching TextField Color, Empty onClick)
                    FloatingActionButton(
                        onClick = { },
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(bottom = 8.dp, end = 4.dp)
                            .size(56.dp),
                        shape = RoundedCornerShape(16.dp),
                        containerColor = inputFieldColor,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_add),
                            contentDescription = "Add",
                            tint = Color.Black,
                            modifier = Modifier.size(28.dp),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TravelInputField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholderText: String,
    backgroundColor: Color,
    textColor: Color,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = placeholderText,
                color = textColor,
                fontSize = 14.sp,
                fontFamily = Poppins,
            )
        },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = backgroundColor,
            unfocusedContainerColor = backgroundColor,
            disabledContainerColor = backgroundColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
        ),
        singleLine = true,
    )
}

@Preview(showBackground = true)
@Composable
fun DisplayScreenPreview() {
    Week2VPTheme {
        DisplayScreen()
    }
}
