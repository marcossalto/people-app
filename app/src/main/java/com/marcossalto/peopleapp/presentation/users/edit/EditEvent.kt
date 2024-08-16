package com.marcossalto.peopleapp.presentation.users.edit

sealed class EditEvent {
    data class EnterName(val name: String) : EditEvent()
    data class EnterLastName(val lastName: String) : EditEvent()
    data class EnterAge(val age: String) : EditEvent()
    data object AddUser : EditEvent()
}
