package com.marcossalto.peopleapp.presentation.home

import com.marcossalto.peopleapp.domain.repository.Users

data class HomeState(
    val users: Users = emptyList()
)
