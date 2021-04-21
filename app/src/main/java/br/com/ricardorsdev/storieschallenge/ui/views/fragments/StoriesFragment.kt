package br.com.ricardorsdev.storieschallenge.ui.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.com.ricardorsdev.storieschallenge.R
import br.com.ricardorsdev.storieschallenge.components.StoriesViewListener
import br.com.ricardorsdev.storieschallenge.databinding.FragmentStoriesBinding
import br.com.ricardorsdev.storieschallenge.ui.viewModels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StoriesFragment : Fragment() {

	private val viewModel: MainViewModel by viewModels()
	private lateinit var binding: FragmentStoriesBinding

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_stories, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		setObservers()
		setListener()
		viewModel.getStoredImages()
	}

	private fun setObservers() {
		viewModel.imageListObservable.observe(viewLifecycleOwner, {
			binding.storiesView.imageList = it
		})
	}

	private fun setListener(){
		binding.storiesView.listener = object : StoriesViewListener {
			override fun onReturnListener() {
				findNavController().navigateUp()
			}

			override fun onFinishListener() {
				findNavController().navigate(R.id.action_storiesFragment_to_finishFragment)
			}
		}
	}
}