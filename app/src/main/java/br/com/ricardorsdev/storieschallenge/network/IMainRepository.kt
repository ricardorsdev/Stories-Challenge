package br.com.ricardorsdev.storieschallenge.network

import br.com.ricardorsdev.storieschallenge.models.ImageResponse
import kotlinx.coroutines.flow.Flow

interface IMainRepository {
	suspend fun getStoriesData(): Flow<Result<ImageResponse>>
}