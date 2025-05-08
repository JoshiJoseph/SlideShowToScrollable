package com.example.slideshowtoscrollable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.slideshowtoscrollable.ui.theme.SlideShowToScrollableTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SlideShowToScrollableTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ImageList(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun ImageList(modifier: Modifier = Modifier) {
    val items = listOf(
        ImageItem("Quote 1 from Marcus Aurelius", R.drawable.marcus1),
        ImageItem("Quote 2 from Marcus Aurelius", R.drawable.marcus2),
        ImageItem("Quote 3 from Marcus Aurelius", R.drawable.marcus3),
        ImageItem("Quote 4 from Marcus Aurelius", R.drawable.marcus4),
        ImageItem("Quote 5 from Marcus Aurelius", R.drawable.marcus5),
        ImageItem("Quote 6 from Marcus Aurelius", R.drawable.marcus6),
        ImageItem("Quote 7 from Marcus Aurelius", R.drawable.marcus7),
        ImageItem("Quote 8 from Marcus Aurelius", R.drawable.marcus8),
        ImageItem("Quote 9 from Marcus Aurelius", R.drawable.marcus9),
        ImageItem("Quote 10 from Marcus Aurelius", R.drawable.marcus10)
    )
    LazyColumn(modifier = modifier.padding(16.dp)) {
        items(items) { item ->
            ImageCard(item)
        }
    }
}
@Composable
fun ImageCard(item: ImageItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 12.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = item.caption, style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(item.imageRes),
                contentDescription = item.caption,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        }
    }
}
