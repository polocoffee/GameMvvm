package com.banklannister.gamemvvm.repo

import com.banklannister.gamemvvm.data.local.GameDao
import com.banklannister.gamemvvm.data.local.GameEntity
import com.banklannister.gamemvvm.data.remote.GameService
import com.banklannister.gamemvvm.domain.GameItem
import com.banklannister.gamemvvm.domain.toDomain
import javax.inject.Inject

class GameRepository @Inject constructor(
    private val gameService: GameService,
    private val gameDao: GameDao
) {
    suspend fun getGameFromApi(): List<GameItem> {
        val games = gameService.getGames()
        return games.map { it.toDomain() }
    }

    suspend fun getGamesFromDatabase(): List<GameItem>{
        val games = gameDao.getGames()
        return games.map { it.toDomain() }
    }

    suspend fun insertGames(games: List<GameEntity>){
        gameDao.insertGames(games)
    }

    suspend fun deleteGames(){
        gameDao.deleteGames()
    }
}