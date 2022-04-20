package kg.geektech.blurresults.domain.results.repository

import kg.geektech.blurresults.domain.entity.ResultGameEntity

interface AddResultRepository {

    suspend fun addResult(result: ResultGameEntity)

}