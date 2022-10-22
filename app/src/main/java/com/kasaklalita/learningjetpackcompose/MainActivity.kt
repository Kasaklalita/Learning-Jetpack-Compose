package com.kasaklalita.learningjetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kasaklalita.learningjetpackcompose.ui.theme.Gray100
import com.kasaklalita.learningjetpackcompose.ui.theme.LearningJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyRow(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth().background(Gray100)
            ) {
                itemsIndexed(
                    listOf(
                        ItemRowModel(R.drawable.ibishopi, "Kasak 1"),
                        ItemRowModel(R.drawable.ibishopi, "Kasak 2"),
                        ItemRowModel(R.drawable.ibishopi, "Kasak 3"),
                        ItemRowModel(R.drawable.ibishopi, "Kasak 4"),
                        ItemRowModel(R.drawable.ibishopi, "Kasak 5"),
                        ItemRowModel(R.drawable.ibishopi, "Kasak 6"),
                    )
                ) { index, item ->
                    ItemRow(item = item)
                }
            }
        }
    }
}

@Preview
@Composable
private fun CircleItem() {
    val counter = remember { mutableStateOf(0) }
    val color = remember { mutableStateOf(Color.Blue) }
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(color = color.value, shape = CircleShape)
            .clickable {
                when (++counter.value) {
                    10 -> color.value = Color.Red
                    20 -> color.value = Color.Green
                }
            },
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = counter.value.toString(),
            style = TextStyle(color = Color.White, fontSize = 20.sp)
        )
    }
}

//Box(modifier = Modifier.fillMaxSize(),
//contentAlignment = Alignment.Center) {
//    Text(text = "Aasdfasf")
//}