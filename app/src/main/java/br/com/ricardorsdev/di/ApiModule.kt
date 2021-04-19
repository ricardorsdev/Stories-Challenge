package br.com.ricardorsdev.di

import br.com.ricardorsdev.api.IApi
import br.com.ricardorsdev.storieschallenge.network.IMainRepository
import br.com.ricardorsdev.storieschallenge.network.MainRepository
import br.com.ricardorsdev.storieschallenge.util.Constants
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

	@Provides
	@Singleton
	fun providesOkHttpClient() : OkHttpClient = OkHttpClient.Builder()
			.addNetworkInterceptor(StethoInterceptor())
			.build()

	@Provides
	@Singleton
	fun providesRetrofit(): Retrofit = Retrofit.Builder()
			.baseUrl(Constants.BASE_URL)
			.client(providesOkHttpClient())
			.addConverterFactory(GsonConverterFactory.create())
			.addCallAdapterFactory(CoroutineCallAdapterFactory())
			.build()

	@Provides
	@Singleton
	fun provideApi(retrofit: Retrofit): IApi = retrofit.create(IApi::class.java)

}