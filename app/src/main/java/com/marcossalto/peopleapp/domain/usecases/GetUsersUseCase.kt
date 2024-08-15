package com.marcossalto.peopleapp.domain.usecases

import com.marcossalto.peopleapp.domain.repository.UserRepository
import com.marcossalto.peopleapp.domain.repository.Users
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    operator fun invoke(): Flow<Users> = userRepository.getUsersFromRoom()
}
