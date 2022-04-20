package kg.geektech.blurresults.data.results.repository

import kg.geektech.blurresults.data.results.local.ResultsDao
import kg.geektech.blurresults.domain.entity.ResultGameEntity
import kg.geektech.blurresults.domain.results.repository.RemoveResultRepository
import javax.inject.Inject

class RemoveResultRepositoryImpl @Inject constructor(private val resultsDao: ResultsDao) :
    RemoveResultRepository {

    override suspend fun removeResult(result: ResultGameEntity) {
        resultsDao.deleteResult(result)
    }

}