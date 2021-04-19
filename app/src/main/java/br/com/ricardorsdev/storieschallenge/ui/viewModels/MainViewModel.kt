package br.com.ricardorsdev.storieschallenge.ui.viewModels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ricardorsdev.storieschallenge.data.AppDatabase
import br.com.ricardorsdev.storieschallenge.data.entities.ImageEntity
import br.com.ricardorsdev.storieschallenge.models.Image
import br.com.ricardorsdev.storieschallenge.network.IMainRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
	private val repository: IMainRepository,
	private val db: AppDatabase
): ViewModel() {

	val state = MutableLiveData<Boolean>()

	fun getStoriesData() {
		viewModelScope.launch {
			repository.getStoriesData().collect { result ->
				result.onSuccess {
					storeImages(it.images)

					state.postValue(true)
				}
				result.onFailure { throwable ->
					throwable.printStackTrace()
				}
			}
		}
	}

	private fun storeImages(images: List<Image>) {
		Thread {
			images.forEach { image ->
				db.imageDao().insertAll(
					ImageEntity(
						id = image.id,
						url = image.url,
						largeUrl = image.largeUrl
					)
				)
			}
		}.start()
	}

}
