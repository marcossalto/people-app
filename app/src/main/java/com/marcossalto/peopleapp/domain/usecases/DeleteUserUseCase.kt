package com.marcossalto.peopleapp.domain.usecases

import com.marcossalto.peopleapp.domain.model.User
import com.marcossalto.peopleapp.domain.repository.UserRepository
import javax.inject.Inject

class DeleteUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(user: User) = userRepository.deleteUserFromRoom(user)
}
