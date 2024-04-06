package com.example.androidapp.ui.journalingscreen

import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidapp.R
import com.example.androidapp.ui.theme.BorderEmojiCardColor
import com.example.androidapp.ui.theme.BorderEmojiSymptomsColor
import com.example.androidapp.ui.theme.EmojiCardColor
import com.example.androidapp.ui.theme.MoodCompColor
import com.example.androidapp.ui.theme.SymptomsCompColor

@Composable
fun MoodComposable () {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MoodCompColor,
        ),
        modifier = Modifier
            .size(width = 400.dp, height = 270.dp)
            .padding(10.dp)
    ) {
        Text(
            modifier = Modifier.padding(
                start = 19.dp, top = 10.dp,
            ),
            text = "Mood",
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(2.dp))
        
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // First row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                var isHappyEmojiOutlined by remember { mutableStateOf(false) }
                ClickableCard(
                    modifier = Modifier
                        .size(width = 100.dp, height = 50.dp)
                        .border(
                            border = BorderStroke(
                                4.dp,
                                if (isHappyEmojiOutlined) BorderEmojiCardColor else Color.Transparent
                            ),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clickable { isHappyEmojiOutlined = !isHappyEmojiOutlined }, // Toggle outline on click,
                ) {
                    EmojiWithText(
                        emojiId = R.drawable.happy_emoji, // Replace with your actual emoji resource ID
                        description = "Happy"
                    )
                }

                var isCalmEmojiOutlined by remember { mutableStateOf(false) }
                ClickableCard(
                    modifier = Modifier
                        .size(width = 100.dp, height = 50.dp)
                        .border(
                            border = BorderStroke(
                                4.dp,
                                if (isCalmEmojiOutlined) BorderEmojiCardColor else Color.Transparent
                            ),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clickable { isCalmEmojiOutlined = !isCalmEmojiOutlined }

                ) {
                    EmojiWithText(
                        emojiId = R.drawable.calm_emoji,
                        description = "Calm"
                    )
                }

                var isMoodyEmojiOutlined by remember { mutableStateOf(false) }
                ClickableCard(
                    modifier = Modifier
                        .size(width = 100.dp, height = 50.dp)
                        .border(
                            border = BorderStroke(
                                4.dp,
                                if (isMoodyEmojiOutlined) BorderEmojiCardColor else Color.Transparent
                            ),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clickable { isMoodyEmojiOutlined = !isMoodyEmojiOutlined }

                ) {
                    EmojiWithText(
                        emojiId = R.drawable.moody_emoji,
                        description = "Moody"
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                var isFriskyEmojiOutlined by remember { mutableStateOf(false) }
                ClickableCard(
                    modifier = Modifier
                        .size(width = 98.dp, height = 50.dp)
                        .border(
                            border = BorderStroke(
                                4.dp,
                                if (isFriskyEmojiOutlined) BorderEmojiCardColor else Color.Transparent
                            ),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clickable { isFriskyEmojiOutlined = !isFriskyEmojiOutlined }

                ) {
                    EmojiWithText(
                        emojiId = R.drawable.frisky_emoji, // Replace with your actual emoji resource ID
                        description = "Frisky"
                    )
                }

                var isMoodSwingsEmojiOutlined by remember { mutableStateOf(false) }
                ClickableCard(
                    modifier = Modifier
                        .size(width = 100.dp, height = 50.dp)
                        .border(
                            border = BorderStroke(
                                4.dp,
                                if (isMoodSwingsEmojiOutlined) BorderEmojiCardColor else Color.Transparent
                            ),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clickable { isMoodSwingsEmojiOutlined = !isMoodSwingsEmojiOutlined }

                ) {
                    EmojiWithText(
                        emojiId = R.drawable.mood_swings_emoji,
                        description = "Mood Swings"
                    )
                }

                var isConfusedEmojiOutlined by remember { mutableStateOf(false) }
                ClickableCard(
                    modifier = Modifier
                        .size(width = 114.dp, height = 50.dp)
                        .border(
                            border = BorderStroke(
                                4.dp,
                                if (isConfusedEmojiOutlined) BorderEmojiCardColor else Color.Transparent
                            ),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clickable { isConfusedEmojiOutlined = !isConfusedEmojiOutlined }

                ) {
                    EmojiWithText(
                        emojiId = R.drawable.confused_emoji,
                        description = "Confused"
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                var isSadEmojiOutlined by remember { mutableStateOf(false) }
                ClickableCard(
                    modifier = Modifier
                        .size(width = 85.dp, height = 50.dp)
                        .border(
                            border = BorderStroke(
                                4.dp,
                                if (isSadEmojiOutlined) BorderEmojiCardColor else Color.Transparent
                            ),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clickable { isSadEmojiOutlined = !isSadEmojiOutlined }

                ) {
                    EmojiWithText(
                        emojiId = R.drawable.sad_emoji,
                        description = "Sad"
                    )
                }

                var isDepressedEmojiOutlined by remember { mutableStateOf(false) }
                ClickableCard(
                    modifier = Modifier
                        .size(width = 122.dp, height = 50.dp)
                        .border(
                            border = BorderStroke(
                                4.dp,
                                if (isDepressedEmojiOutlined) BorderEmojiCardColor else Color.Transparent
                            ),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clickable { isDepressedEmojiOutlined = !isDepressedEmojiOutlined }

                ) {
                    EmojiWithText(
                        emojiId = R.drawable.depressed_emoji,
                        description = "Depressed"
                    )
                }

                var isLowEnergyEmojiOutlined by remember { mutableStateOf(false) }
                ClickableCard(
                    modifier = Modifier
                        .size(width = 100.dp, height = 50.dp)
                        .border(
                            border = BorderStroke(
                                4.dp,
                                if (isLowEnergyEmojiOutlined) BorderEmojiCardColor else Color.Transparent
                            ),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clickable { isLowEnergyEmojiOutlined = !isLowEnergyEmojiOutlined }

                ) {
                    EmojiWithText(
                        emojiId = R.drawable.low_energy_emoji,
                        description = "Low energy"
                    )
                }
            }

        }

    }
}

@Composable
fun SymptomsComposable() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = SymptomsCompColor,
        ),
        modifier = Modifier
            .size(width = 400.dp, height = 270.dp)
            .padding(10.dp)
    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            text = "Symptoms",
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(2.dp))

        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // First row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                var isThumbsUpEmojiOutlined by remember { mutableStateOf(false) }
                ClickableCard(
                    modifier = Modifier
                        .size(width = 170.dp, height = 50.dp)
                        .border(
                            border = BorderStroke(4.dp, if (isThumbsUpEmojiOutlined) BorderEmojiSymptomsColor else Color.Transparent),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clickable { isThumbsUpEmojiOutlined = !isThumbsUpEmojiOutlined }, // Toggle outline on click,
                ) {
                    EmojiWithText(
                        emojiId = R.drawable.everything_is_fine, // Replace with your actual emoji resource ID
                        description = "Everything is fine"
                    )
                }

                var isSicknessEmojiOutlined by remember { mutableStateOf(false) }
                ClickableCard(
                    modifier = Modifier
                        .size(width = 140.dp, height = 50.dp)
                        .border(
                            border = BorderStroke(4.dp, if (isSicknessEmojiOutlined) BorderEmojiSymptomsColor else Color.Transparent),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clickable { isSicknessEmojiOutlined = !isSicknessEmojiOutlined }

                ) {
                    EmojiWithText(
                        emojiId = R.drawable.sickness,
                        description = "Sickness"
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                var isBingedEmojiOutlined by remember { mutableStateOf(false) }
                ClickableCard(
                    modifier = Modifier
                        .size(width = 120.dp, height = 50.dp)
                        .border(
                            border = BorderStroke(4.dp, if (isBingedEmojiOutlined) BorderEmojiSymptomsColor else Color.Transparent),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clickable { isBingedEmojiOutlined = !isBingedEmojiOutlined }

                ) {
                    EmojiWithText(
                        emojiId = R.drawable.binged, // Replace with your actual emoji resource ID
                        description = "Binged"
                    )
                }

                var isPurgedEmojiOutlined by remember { mutableStateOf(false) }
                ClickableCard(
                    modifier = Modifier
                        .size(width = 110.dp, height = 50.dp)
                        .border(
                            border = BorderStroke(4.dp, if (isPurgedEmojiOutlined) BorderEmojiSymptomsColor else Color.Transparent),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clickable { isPurgedEmojiOutlined = !isPurgedEmojiOutlined }

                ) {
                    EmojiWithText(
                        emojiId = R.drawable.purged,
                        description = "Purged"
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                var isRestrictedEmojiOutlined by remember { mutableStateOf(false) }
                ClickableCard(
                    modifier = Modifier
                        .size(width = 160.dp, height = 50.dp)
                        .border(
                            border = BorderStroke(4.dp, if (isRestrictedEmojiOutlined) BorderEmojiSymptomsColor else Color.Transparent),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clickable { isRestrictedEmojiOutlined = !isRestrictedEmojiOutlined }

                ) {
                    EmojiWithText(
                        emojiId = R.drawable.restricted,
                        description = "Restricted"
                    )
                }

                var isHeadacheEmojiOutlined by remember { mutableStateOf(false) }
                ClickableCard(
                    modifier = Modifier
                        .size(width = 130.dp, height = 50.dp)
                        .border(
                            border = BorderStroke(4.dp, if (isHeadacheEmojiOutlined) BorderEmojiSymptomsColor else Color.Transparent),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .clickable { isHeadacheEmojiOutlined = !isHeadacheEmojiOutlined }

                ) {
                    EmojiWithText(
                        emojiId = R.drawable.headache,
                        description = "Headache"
                    )
                }
            }

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClickableCard(
    modifier: Modifier = Modifier,
    //onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = EmojiCardColor
        ),
        shape = RoundedCornerShape(20.dp),
        //onClick = onClick,
        modifier = modifier

    ) {
        content()
    }
}

@Composable
fun EmojiWithText(
    emojiId: Int, // Resource ID of the emoji
    description: String // Text describing the emoji
) {
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)

    ) {
        Image(
            painter = painterResource(id = emojiId),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
//                .fillMaxHeight()
//                .width(40.dp)
                .size(40.dp)
                .padding(start = 3.dp, top = 6.dp)
        )

        Text(
            text = description,
            fontSize = 15.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 43.dp)
        )
    }
}

@Composable
fun QuestionMarkWithTooltip() {
    var showTooltip by remember { mutableStateOf(false) }

    val iconModifier = Modifier
        .size(30.dp)
        .offset(x = 285.dp, y = 2.dp)
        .clickable { showTooltip = !showTooltip }

    Icon(
        imageVector = Icons.Default.Info,
        contentDescription = "Question Mark",
        modifier = iconModifier
    )

    if (showTooltip) {
        // Display the tooltip when the user clicks the icon
        Box(
            modifier = Modifier
                .offset(x = 100.dp, y = 2.dp) // Adjust the offset as needed
                .background(color = Color.LightGray)
                .padding(8.dp)
        ) {
            Text(
                text ="For e.g: How was your day?\n" +
                        "Did you feel stressed today? \n" +
                        "Write down any thoughts you experienced\n"
                        + "that had an impact on your day.",
                fontSize = 10.sp,
            )
        }
    }
}