package kg.geektech.blurresults.data.game.repository

import kg.geektech.blurresults.data.game.local.GameApi
import kg.geektech.blurresults.domain.entity.PlayerResult
import kg.geektech.blurresults.domain.game.repository.GetPlayersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPlayersRepositoryImpl @Inject constructor(private val gameApi: GameApi) : GetPlayersRepository {

    override suspend fun getPlayers(): Flow<List<PlayerResult>> {
        return flow {
            emit(gameApi.getPlayers())
        }
    }

}