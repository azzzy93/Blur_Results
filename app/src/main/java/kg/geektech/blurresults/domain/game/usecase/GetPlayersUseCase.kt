package kg.geektech.blurresults.domain.game.usecase

import kg.geektech.blurresults.domain.entity.PlayerResult
import kg.geektech.blurresults.domain.game.repository.GetPlayersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPlayersUseCase @Inject constructor(private val repository: GetPlayersRepository) {

    suspend fun invoke(): Flow<List<PlayerResult>> {
        return repository.getPlayers()
    }

}