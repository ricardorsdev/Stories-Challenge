package br.com.ricardorsdev.storieschallenge.ui.views.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.ricardorsdev.storieschallenge.R
import br.com.ricardorsdev.storieschallenge.ui.viewModels.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

	private val viewModel: SplashViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_splash)

		setObservers()
		viewModel.getStoriesData()
	}


	private fun setObservers() {
		viewModel.state.observe(this, {
			startActivity(Intent(this, MainActivity::class.java))
			finish()
		})
	}
}