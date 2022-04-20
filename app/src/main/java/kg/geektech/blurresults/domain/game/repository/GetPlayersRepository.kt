package kg.geektech.blurresults.domain.game.repository

import kg.geektech.blurresults.domain.entity.PlayerResult
import kotlinx.coroutines.flow.Flow

interface GetPlayersRepository {

    suspend fun getPlayers(): Flow<List<PlayerResult>>

}