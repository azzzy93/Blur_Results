package kg.geektech.blurresults.domain.results.usecase

import kg.geektech.blurresults.domain.entity.ResultGameEntity
import kg.geektech.blurresults.domain.results.repository.GetResultsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetResultsUseCase @Inject constructor(private val repository: GetResultsRepository) {

    suspend fun invoke(): Flow<List<ResultGameEntity>> {
        return repository.getResults()
    }

}