package kg.geektech.blurresults.di.game

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kg.geektech.blurresults.data.game.repository.GetPlayersRepositoryImpl
import kg.geektech.blurresults.data.game.local.GameApi
import kg.geektech.blurresults.data.game.repository.EditPlayerRepositoryImpl
import kg.geektech.blurresults.domain.game.repository.EditPlayerRepository
import kg.geektech.blurresults.domain.game.repository.GetPlayersRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object GameModule {

    @Provides
    @Singleton
    fun provideGameApi(): GameApi {
        return GameApi()
    }

    @Provides
    @Singleton
    fun provideGetPlayersRepository(gameApi: GameApi): GetPlayersRepository {
        return GetPlayersRepositoryImpl(gameApi)
    }

    @Provides
    @Singleton
    fun provideEditPlayersRepository(gameApi: GameApi): EditPlayerRepository {
        return EditPlayerRepositoryImpl(gameApi)
    }

}