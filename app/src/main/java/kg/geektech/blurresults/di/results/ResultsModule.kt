package kg.geektech.blurresults.di.results

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kg.geektech.blurresults.data.results.local.AppDatabase
import kg.geektech.blurresults.data.results.local.ResultsDao
import kg.geektech.blurresults.data.results.repository.AddResultRepositoryImpl
import kg.geektech.blurresults.data.results.repository.GetResultByIdRepositoryImpl
import kg.geektech.blurresults.data.results.repository.GetResultsRepositoryImpl
import kg.geektech.blurresults.data.results.repository.RemoveResultRepositoryImpl
import kg.geektech.blurresults.domain.results.repository.AddResultRepository
import kg.geektech.blurresults.domain.results.repository.GetResultByIdRepository
import kg.geektech.blurresults.domain.results.repository.GetResultsRepository
import kg.geektech.blurresults.domain.results.repository.RemoveResultRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ResultsModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "database")
            .build()
    }

    @Provides
    @Singleton
    fun provideResultsDao(appDatabase: AppDatabase): ResultsDao {
        return appDatabase.resultsDao()
    }

    @Provides
    @Singleton
    fun provideGetResultsRepository(resultsDao: ResultsDao): GetResultsRepository {
        return GetResultsRepositoryImpl(resultsDao)
    }

    @Provides
    @Singleton
    fun provideRemoveResultRepository(resultsDao: ResultsDao): RemoveResultRepository {
        return RemoveResultRepositoryImpl(resultsDao)
    }

    @Provides
    @Singleton
    fun provideAddResultRepository(resultsDao: ResultsDao): AddResultRepository {
        return AddResultRepositoryImpl(resultsDao)
    }

    @Provides
    @Singleton
    fun provideGetResultByIdRepository(resultsDao: ResultsDao): GetResultByIdRepository {
        return GetResultByIdRepositoryImpl(resultsDao)
    }

}