package br.com.ricardorsdev.storieschallenge.ui.views.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.ricardorsdev.storieschallenge.R
import br.com.ricardorsdev.storieschallenge.ui.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

	private val viewModel: MainViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		setObservers()
		viewModel.getStoredImages()
	}

	private fun setObservers() {
		viewModel.imageListObservable.observe(this, {

		})
	}
}