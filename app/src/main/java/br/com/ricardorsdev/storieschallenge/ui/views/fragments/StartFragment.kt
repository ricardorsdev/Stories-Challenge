package br.com.ricardorsdev.storieschallenge.ui.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import br.com.ricardorsdev.storieschallenge.R
import br.com.ricardorsdev.storieschallenge.databinding.FragmentStartBinding
import br.com.ricardorsdev.storieschallenge.databinding.FragmentStoriesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StartFragment : Fragment() {

	private lateinit var binding: FragmentStartBinding

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_start, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		setActions()
	}

	private fun setActions() {
		binding.btnStart.setOnClickListener {
			findNavController().navigate(R.id.action_startFragment_to_storiesFragment)
		}
	}
}