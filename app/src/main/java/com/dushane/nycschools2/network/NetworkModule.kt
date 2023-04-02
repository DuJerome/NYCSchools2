package com.dushane.nycschools2.network

import com.dushane.nycschools2.model.School
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideOkhttpInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Singleton
    @Provides
    fun provideOkhttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient().newBuilder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        val moshi =  Moshi.Builder().build()
        val listSchoolType = Types.newParameterizedType(MutableList::class.java, School::class.java)
        moshi.adapter<MutableList<School>>(listSchoolType)
        return moshi
    }

    @Singleton
    @Provides
    fun provideBaseUrl(): String {
        return "https://data.cityofnewyork.us/resource/"
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        moshi: Moshi,
        baseUrl: String
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }
}