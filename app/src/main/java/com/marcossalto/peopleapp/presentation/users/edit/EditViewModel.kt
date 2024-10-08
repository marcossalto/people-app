package com.marcossalto.peopleapp.presentation.users.edit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcossalto.peopleapp.domain.model.User
import com.marcossalto.peopleapp.domain.usecases.AddUserUseCase
import com.marcossalto.peopleapp.domain.usecases.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val addUserUseCase: AddUserUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _userName = mutableStateOf(TextFieldState())
    val userName: State<TextFieldState> = _userName

    private val _userLastName = mutableStateOf(TextFieldState())
    val userLastName: State<TextFieldState> = _userLastName

    private val _userAge = mutableStateOf(TextFieldState())
    val userAge: State<TextFieldState> = _userAge

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    var currentUserId: Int? = null

    init {
        savedStateHandle.get<Int>("userId")?.let { userId ->
            if (userId != -1) {
                viewModelScope.launch {
                    getUserUseCase(userId)?.also { user ->
                        currentUserId = user.id
                        _userName.value = userName.value.copy(
                            text = user.name
                        )
                        _userLastName.value = userLastName.value.copy(
                            text = user.lastName
                        )
                        _userAge.value = userAge.value.copy(
                            text = user.age.toString()
                        )
                    }
                }
            }
        }
    }

    fun onEvent(
        event: EditEvent
    ) {
        when (event) {
            is EditEvent.EnterName -> {
                _userName.value = userName.value.copy(
                    text = event.name
                )
            }

            is EditEvent.EnterLastName -> {
                _userLastName.value = userLastName.value.copy(
                    text = event.lastName
                )
            }

            is EditEvent.EnterAge -> {
                _userAge.value = userAge.value.copy(
                    text = event.age
                )
            }

            is EditEvent.AddUser -> {
                viewModelScope.launch {
                    addUserUseCase(
                        User(
                            name = userName.value.text,
                            lastName = userLastName.value.text,
                            age = userAge.value.text.toInt(),
                            id = currentUserId
                        )
                    )
                    _eventFlow.emit(UiEvent.AddUser)
                }
            }
        }
    }

    sealed class UiEvent {
        data object AddUser : UiEvent()
    }
}
