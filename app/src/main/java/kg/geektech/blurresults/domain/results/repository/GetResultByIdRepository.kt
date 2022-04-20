package kg.geektech.blurresults.domain.results.repository

import kg.geektech.blurresults.domain.entity.ResultGameEntity
import kotlinx.coroutines.flow.Flow

interface GetResultByIdRepository {

    suspend fun getResultById(id: Int): Flow<ResultGameEntity>

}