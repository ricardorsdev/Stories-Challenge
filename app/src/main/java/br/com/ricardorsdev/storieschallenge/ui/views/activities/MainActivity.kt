package br.com.ricardorsdev.storieschallenge.ui.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.ricardorsdev.storieschallenge.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
	}

}