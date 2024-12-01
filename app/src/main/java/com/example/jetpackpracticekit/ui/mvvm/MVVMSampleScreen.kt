package com.example.jetpackpracticekit.ui.mvvm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.jetpackpracticekit.data.model.Profile
import com.example.jetpackpracticekit.data.repository.UserRepoImpl
import com.example.jetpackpracticekit.ui.main.MyAppBar

@Composable
fun MVVMSampleScreen(
    navController: NavController,
    userViewModel: UserViewModel = viewModel(
        factory = UserViewModelFactory(
            UserRepoImpl()
        )
    )
) {
    val profiles by userViewModel.items.collectAsState()

    Scaffold(topBar = {
        MyAppBar(
            title = "Jetpack UI Practice Kit",
            onBackPressed = { navController.popBackStack() })
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Text(text = "Item List", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(profiles) { profile ->
                    ItemRow(profile)
                    Divider()
                }
            }
        }
    }
}

@Composable
fun ItemRow(item: Profile) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(text = item.name, style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = item.userName, style = MaterialTheme.typography.bodyMedium)
    }
}
