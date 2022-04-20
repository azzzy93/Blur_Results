package kg.geektech.blurresults.domain.results.usecase

import kg.geektech.blurresults.domain.entity.ResultGameEntity
import kg.geektech.blurresults.domain.results.repository.GetResultByIdRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetResultByIdUseCase @Inject constructor(private val repository: GetResultByIdRepository) {

    suspend fun invoke(id: Int): Flow<ResultGameEntity> {
        return repository.getResultById(id)
    }

}