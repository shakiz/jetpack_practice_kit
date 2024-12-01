package com.example.jetpackpracticekit.ui.richuisample

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetpackpracticekit.ui.main.MyAppBar

@Composable
fun RichUILayoutScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    val pagerState = rememberPagerState(pageCount = { 5 }, initialPage = 1)

    Scaffold(
        topBar = {
            MyAppBar(
                title = "Rich UI Sample",
                Icons.Filled.ArrowBack,
                onBackPressed = { navController.popBackStack() })
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // LazyColumn example
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(10) { index ->
                    Text("LazyColumn Item #$index", modifier = Modifier.padding(8.dp))
                }
            }

            // LazyRow example
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                items(10) { index ->
                    Text("LazyRow Item #$index", modifier = Modifier.padding(8.dp))
                }
            }

            // HorizontalScroll example
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(Color.LightGray)
                    .horizontalScroll(scrollState)
            ) {
                repeat(10) { index ->
                    Text("HorizontalScroll Item #$index", modifier = Modifier.padding(8.dp))
                }
            }

            // VerticalScroll example
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color.LightGray)
                    .verticalScroll(scrollState)
            ) {
                repeat(5) { index ->
                    Text("VerticalScroll Item #$index", modifier = Modifier.padding(8.dp))
                }
            }

            // Define a sample list of items to display in the pager
            val items = listOf("Page 1", "Page 2", "Page 3", "Page 4", "Page 5")

            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) { page ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFBB86FC))
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(items[page], color = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Divider example
            Divider(color = Color.Gray, thickness = 1.dp)

            Spacer(modifier = Modifier.height(8.dp))

            // Tooltip - As there’s no native support, we could use a custom-built solution, but here’s a simple simulated approach:
            var tooltipVisible by remember { mutableStateOf(false) }
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .background(Color.Blue)
                    .padding(8.dp)
                    .clickable { tooltipVisible = !tooltipVisible },
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Hover")
                if (tooltipVisible) {
                    Text(
                        text = "Tooltip Text",
                        color = Color.White,
                        modifier = Modifier
                            .background(Color.Black)
                            .padding(4.dp)
                    )
                }
            }
        }
    }
}
