package com.dushane.nycschools2.network

import com.dushane.nycschools2.repository.SATScoresRepository
import com.dushane.nycschools2.ui.viewmodel.SATScoresViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SATScoresViewModelModule {

    @Singleton
    @Provides
    fun providesSATScoresListServices(retrofit: Retrofit): SATScoresListServices =
        retrofit.create(SATScoresListServices::class.java)

    @Singleton
    @Provides
    fun providesSATScoresRepository(
        satScoresListServices: SATScoresListServices
    ): SATScoresRepository {
        return SATScoresRepository(satScoresListServices)
    }

    @Singleton
    @Provides
    fun provideSATScoresViewModel(satScoresRepository: SATScoresRepository): SATScoresViewModel=
        SATScoresViewModel(satScoresRepository)
}