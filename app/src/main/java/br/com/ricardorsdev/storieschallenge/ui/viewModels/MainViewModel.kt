package br.com.ricardorsdev.storieschallenge.ui.viewModels

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.ricardorsdev.storieschallenge.network.IMainRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
	private val repository: IMainRepository
): ViewModel() {

	fun getStoriesData() {
		viewModelScope.launch {
			repository.getStoriesData().collect { result ->
				result.onSuccess {
					Log.e("RICARDO SUCCESS = ", it.toString())
				}
				result.onFailure {
					Log.e("RICARDO FAIL = ", it.toString())
				}
			}
		}
	}
}
