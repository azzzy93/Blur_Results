package kg.geektech.blurresults.domain.results.repository

import kg.geektech.blurresults.domain.entity.ResultGameEntity

interface RemoveResultRepository {

    suspend fun removeResult(result: ResultGameEntity)

}