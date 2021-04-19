package br.com.ricardorsdev.di

import br.com.ricardorsdev.api.IApi
import br.com.ricardorsdev.storieschallenge.network.IMainRepository
import br.com.ricardorsdev.storieschallenge.network.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

	@Provides
	fun providesMainRepository(
		retrofit: IApi
	): IMainRepository = MainRepository(retrofit)
}