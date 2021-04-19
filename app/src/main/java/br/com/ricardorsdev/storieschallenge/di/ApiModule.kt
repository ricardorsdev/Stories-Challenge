package br.com.ricardorsdev.storieschallenge.di

import br.com.ricardorsdev.storieschallenge.api.IApi
import br.com.ricardorsdev.storieschallenge.util.Constants
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
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
@InstallIn(ActivityRetainedComponent::class)
object ApiModule {

	@Provides
	fun providesOkHttpClient() : OkHttpClient = OkHttpClient.Builder()
			.addNetworkInterceptor(StethoInterceptor())
			.build()

	@Provides
	fun providesRetrofit(): Retrofit = Retrofit.Builder()
			.baseUrl(Constants.BASE_URL)
			.client(providesOkHttpClient())
			.addConverterFactory(GsonConverterFactory.create())
			.addCallAdapterFactory(CoroutineCallAdapterFactory())
			.build()

	@Provides
	fun provideApi(retrofit: Retrofit): IApi = retrofit.create(IApi::class.java)

}