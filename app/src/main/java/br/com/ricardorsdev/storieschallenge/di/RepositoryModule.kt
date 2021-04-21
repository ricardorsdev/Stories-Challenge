package br.com.ricardorsdev.storieschallenge.di

import br.com.ricardorsdev.storieschallenge.api.IApi
import br.com.ricardorsdev.storieschallenge.network.IMainRepository
import br.com.ricardorsdev.storieschallenge.network.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
object RepositoryModule {

	@Provides
	fun providesMainRepository(
		retrofit: IApi
	): IMainRepository = MainRepository(retrofit)
}