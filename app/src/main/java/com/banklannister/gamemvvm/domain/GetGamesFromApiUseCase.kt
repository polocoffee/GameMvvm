package com.banklannister.gamemvvm.domain

import com.banklannister.gamemvvm.data.local.toDatabase
import com.banklannister.gamemvvm.repo.GameRepository
import javax.inject.Inject


class GetGamesFromApiUseCase @Inject constructor(private val gameRepository: GameRepository) {
    suspend operator fun invoke(): List<GameItem> {
        val games = gameRepository.getGameFromApi()
        return if (games.isNotEmpty()) {
            gameRepository.deleteGames()
            gameRepository.insertGames(games.map { it.toDatabase() })
            games
        } else {
            emptyList()
        }
    }
}