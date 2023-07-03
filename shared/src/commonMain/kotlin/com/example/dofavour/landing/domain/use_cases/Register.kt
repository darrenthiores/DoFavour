package com.example.dofavour.landing.domain.use_cases

import com.example.dofavour.core.utils.Resource
import com.example.dofavour.landing.domain.repository.LandingRepository

class Register(
    private val repository: LandingRepository
) {
    suspend operator fun invoke(
        email: String,
        password: String
    ): Resource<Unit> {
        return repository.register(
            email = email,
            password = password
        )
    }
}