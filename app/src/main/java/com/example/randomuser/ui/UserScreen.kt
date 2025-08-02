package com.example.randomuser.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.randomuser.domain.User

@Composable
fun UserScreen(
    viewModel: UserViewModel = hiltViewModel(),
) {

    val state by viewModel.state.collectAsStateWithLifecycle()
    when {
        state.isLoading -> {
            LoadingFun()
        }

        state.error != null -> {
            ErrorFun()
        }

        else -> {
            LazyColumn {
                items(state.users) { user ->
                    UserItem(user = user)
                }
            }
        }
    }


}

@Composable
fun LoadingFun(){}

@Composable
fun ErrorFun(){}

@Composable
fun UserItem(user: User){
    Row {

    }
}

