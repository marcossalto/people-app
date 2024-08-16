package com.marcossalto.peopleapp.domain.usecases

import com.marcossalto.peopleapp.domain.model.User
import com.marcossalto.peopleapp.domain.repository.UserRepository
import javax.inject.Inject

class GetUserUseCase  @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(id: Int): User? = userRepository.getUserByIdFromRoom(id)
}
