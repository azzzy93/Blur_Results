package kg.geektech.blurresults.domain.results.usecase

import kg.geektech.blurresults.domain.entity.ResultGameEntity
import kg.geektech.blurresults.domain.results.repository.RemoveResultRepository
import javax.inject.Inject

class RemoveResultUseCase @Inject constructor(private val repository: RemoveResultRepository) {

    suspend fun invoke(result: ResultGameEntity) {
        repository.removeResult(result)
    }

}