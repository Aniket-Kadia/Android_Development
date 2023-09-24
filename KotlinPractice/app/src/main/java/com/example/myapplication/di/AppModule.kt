package com.example.myapplication.di

import com.example.myapplication.interfaces.OrganizationApi
import com.example.myapplication.repositories.OrganizationRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun getGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun getRetrofit(gson: Gson): Retrofit {
        return Retrofit.Builder().baseUrl("http://restapi.adequateshop.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun getOrganizationApi(retrofit: Retrofit): OrganizationApi =
        retrofit.create(OrganizationApi::class.java)

    @Provides
    @Singleton
    fun getRepository(organizationApi: OrganizationApi): OrganizationRepository =
        OrganizationRepository(organizationApi)
}