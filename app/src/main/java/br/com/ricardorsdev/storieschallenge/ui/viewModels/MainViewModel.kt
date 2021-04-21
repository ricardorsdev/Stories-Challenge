package br.com.ricardorsdev.storieschallenge.ui.viewModels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.ricardorsdev.storieschallenge.data.AppDatabase
import br.com.ricardorsdev.storieschallenge.data.entities.ImageEntity

class MainViewModel @ViewModelInject constructor(
	private val db: AppDatabase
): ViewModel() {

	val imageListObservable = MutableLiveData<List<ImageEntity>>()

	fun getStoredImages() {
		Thread {
			val imageList = db.imageDao().getAll()
			if (imageList.isNotEmpty()) {
				imageListObservable.postValue(imageList)
			}
		}.start()
	}

}
