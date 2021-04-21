package br.com.ricardorsdev.storieschallenge.di

import android.content.Context
import androidx.room.Room
import br.com.ricardorsdev.storieschallenge.data.AppDatabase
import br.com.ricardorsdev.storieschallenge.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ActivityRetainedComponent::class)
object DatabaseModule {

	@Provides
	fun providesDatabaseModule(@ApplicationContext context: Context): AppDatabase {
		return Room.databaseBuilder(
			context,
			AppDatabase::class.java, Constants.DB_NAME
		).build()
	}
}