package br.com.ricardorsdev.storieschallenge.api

import br.com.ricardorsdev.storieschallenge.models.ImageResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface IApi {

	@GET(" /api/v1/images/latest")
	fun getLatestImagesAsync(): Deferred<Response<ImageResponse>>

}