package br.com.ricardorsdev.storieschallenge.network

import br.com.ricardorsdev.api.IApi
import br.com.ricardorsdev.storieschallenge.models.ImageResponse
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.net.ssl.HttpsURLConnection

class MainRepository @Inject constructor(
	private val api: IApi
) : IMainRepository  {

	override suspend fun getStoriesData() = flow {
		val req = api.getLatestImagesAsync()
		
		try {
			val res = req.await()

			when (res.code()) {
				HttpsURLConnection.HTTP_OK -> res.body()?.let {
					emit(Result.success(it))
				}

				else -> emit(Result.failure<ImageResponse>(Exception()))
			}

		} catch (t: Throwable) {
			emit(Result.failure<ImageResponse>(Exception()))
		}
	}
}