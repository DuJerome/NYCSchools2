package com.dushane.nycschools2.network

import com.dushane.nycschools2.ui.viewmodel.SchoolViewModel
import com.dushane.nycschools2.repository.SchoolRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SchoolViewModelModule {

    @Singleton
    @Provides
    fun providesSchoolListServices(retrofit: Retrofit): SchoolListServices =
        retrofit.create(SchoolListServices::class.java)

    @Singleton
    @Provides
    fun providesSchoolRepository(
        schoolListServices: SchoolListServices
    ): SchoolRepository {
        return SchoolRepository(schoolListServices = schoolListServices)
    }

    @Singleton
    @Provides
    fun provideSchoolViewModel(schoolRepository: SchoolRepository): SchoolViewModel {
        return SchoolViewModel(schoolRepository = schoolRepository)
    }
}