package com.example.randomuser.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.randomuser.data.GetRandomUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUsers: GetRandomUsersUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(UserState())
    val state: StateFlow<UserState> = _state
    private val intentChannel = Channel<UserIntent>(Channel.UNLIMITED)
    private var currentPage = 1
    init {
        processIntents()
        sendIntent(UserIntent.LoadUsers)
    }

    private fun loadUsers() {

        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            getUsers(currentPage)
                .onEach { users -> _state.update { it.copy(users = it.users + users, isLoading = false) } }
                .catch { e -> _state.update { it.copy(error = e.message, isLoading = false) } }
                .collect()
        }
    }


     fun processIntents() {
        viewModelScope.launch {
            intentChannel.consumeAsFlow().collect { intent ->
                when (intent) {
                    is UserIntent.LoadUsers -> loadUsers()
                }
            }
        }
    }
    fun sendIntent(intent: UserIntent) {
        viewModelScope.launch {
            intentChannel.send(intent)
        }
    }
}