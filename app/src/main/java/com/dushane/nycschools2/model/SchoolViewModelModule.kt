package com.dushane.nycschools2.model

import com.dushane.nycschools2.ui.viewmodel.SchoolViewModel
import com.dushane.nycschools2.network.SchoolListServices
import com.dushane.nycschools2.repository.SchoolRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SchoolViewModelModule {

    @Provides
    fun providesSchoolRepository(
        schoolListServices: SchoolListServices
    ): SchoolRepository {
        return SchoolRepository(schoolListServices = schoolListServices)
    }

    @ViewScoped
    @Provides
    fun provideSchoolViewModel(schoolRepository: SchoolRepository): SchoolViewModel {
        return SchoolViewModel(schoolRepository = schoolRepository)
    }
}