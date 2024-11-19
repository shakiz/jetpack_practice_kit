package com.example.jetpackpracticekit.ui.layoutsample

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LayoutSampleScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("My Layout Example") })
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {

                // Row containing buttons
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(onClick = { /* Handle Action */ }) {
                        Text("Button 1")
                    }
                    Button(onClick = { /* Handle Action */ }) {
                        Text("Button 2")
                    }
                }

                // Box with overlapping elements
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Box Content", modifier = Modifier.align(Alignment.Center))
                    Text("Overlay", modifier = Modifier.align(Alignment.TopEnd))
                }

                // LazyColumn for a vertical scrollable list
                LazyColumn(modifier = Modifier.weight(1f)) {
                    items(100) { index ->
                        Text(
                            text = "Item #$index",
                            modifier = Modifier.padding(16.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                ConstraintLayout(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    //Basic Constraints
                    val (text1, text2, text3, text4, text5, text6, text7, box1, box2, box3) = createRefs()

//                    //Guideline
//                    val guideline = createGuidelineFromTop(0.5f)
//                    Text(
//                        "Text aligned to guideline",
//                        modifier = Modifier.constrainAs(text1) {
//                            top.linkTo(guideline)
//                            start.linkTo(parent.start, margin = 16.dp)
//                            end.linkTo(parent.end, margin = 16.dp)
//                        }
//                    )

                    Text(
                        "Hello",
                        modifier = Modifier.constrainAs(text1) {
                            top.linkTo(parent.top, margin = 16.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                        }
                    )

                    Text(
                        "World",
                        modifier = Modifier.constrainAs(text2) {
                            top.linkTo(text1.bottom, margin = 8.dp)
                            start.linkTo(text1.start)
                        }
                    )

                    createHorizontalChain(box1, box2, box3, chainStyle = ChainStyle.Spread)

                    Box(modifier = Modifier
                        .size(50.dp)
                        .background(Color.Red)
                        .constrainAs(box1) {
                            top.linkTo(text2.bottom)
                        })

                    Box(modifier = Modifier
                        .size(50.dp)
                        .background(Color.Green)
                        .constrainAs(box2) {
                            top.linkTo(text2.bottom)
                        })

                    Box(modifier = Modifier
                        .size(50.dp)
                        .background(Color.Blue)
                        .constrainAs(box3) {
                            top.linkTo(text2.bottom)
                        })

                    Text(
                        "Short text",
                        modifier = Modifier.constrainAs(text3) {
                            top.linkTo(box1.bottom, margin = 16.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                        }
                    )

                    Text(
                        "A much longer text",
                        modifier = Modifier.constrainAs(text4) {
                            top.linkTo(text3.bottom, margin = 8.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                        }
                    )

                    Text(
                        "Aligned to Barrier",
                        modifier = Modifier.constrainAs(text5) {
                            top.linkTo(text4.bottom, margin = 8.dp)
                            start.linkTo(parent.start, margin = 16.dp)
                            end.linkTo(parent.end, margin = 16.dp)
                        }
                    )
                }

                // Spacer to separate sections
                Spacer(modifier = Modifier.height(16.dp))

                // LazyVerticalGrid for a two-dimensional grid layout
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    items(20) { index ->
                        Card(
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Text(text = "Grid Item $index", modifier = Modifier.padding(16.dp))
                        }
                    }
                }
            }
        }
    )
}