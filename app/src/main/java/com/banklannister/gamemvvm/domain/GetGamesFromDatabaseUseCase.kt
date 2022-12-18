package com.banklannister.gamemvvm.domain

import com.banklannister.gamemvvm.repo.GameRepository
import javax.inject.Inject

class GetGamesFromDatabaseUseCase @Inject constructor(private val gameRepository: GameRepository) {
    suspend operator fun invoke(): List<GameItem> {
        val games = gameRepository.getGamesFromDatabase()
        return games.ifEmpty {
            emptyList()
        }
    }

}