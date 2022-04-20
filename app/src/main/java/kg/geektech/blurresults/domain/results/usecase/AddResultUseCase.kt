package kg.geektech.blurresults.domain.results.usecase

import kg.geektech.blurresults.domain.entity.ResultGameEntity
import kg.geektech.blurresults.domain.results.repository.AddResultRepository
import javax.inject.Inject

class AddResultUseCase @Inject constructor(private val addResultRepository: AddResultRepository) {

    suspend fun invoke(result: ResultGameEntity) {
        addResultRepository.addResult(result)
    }

}