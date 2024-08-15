package com.marcossalto.peopleapp.presentation.home

import com.marcossalto.peopleapp.domain.model.User

sealed class HomeEvent {
    data class OnDeleteUser(val user: User) : HomeEvent()
}
