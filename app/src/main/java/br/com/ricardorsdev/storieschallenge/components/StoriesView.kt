package br.com.ricardorsdev.storieschallenge.components

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.MediaController
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import br.com.ricardorsdev.storieschallenge.R
import br.com.ricardorsdev.storieschallenge.data.entities.ImageEntity
import br.com.ricardorsdev.storieschallenge.databinding.ViewStoriesBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.view_stories.view.*


class StoriesView @JvmOverloads constructor(
	context: Context,
	attributeSet: AttributeSet? = null,
	defStyleAttr: Int = 0
) : ConstraintLayout(context, attributeSet, defStyleAttr) {

	var imageList: List<ImageEntity> = mutableListOf()
		set(value) {
			field = value
			setUpProgress()
			updateStoriesView()
		}

	var listener: StoriesViewListener? = null

	private var imagePosition = 0
	private var imageType = PHOTO

	var binding: ViewStoriesBinding = DataBindingUtil.inflate(
		LayoutInflater.from(context),
		R.layout.view_stories,
		this,
		true
	)

	init {
		binding.handler =  object : StoriesViewHandler {
			override fun skip() {
				if (imagePosition < imageList.lastIndex) {
					imagePosition++
					updateStoriesView()
				} else {
					listener?.onFinishListener()
				}
			}

			override fun goBack() {
				if (imagePosition > 0) {
					imagePosition--
					updateStoriesView()
				} else {
					listener?.onReturnListener()
				}
			}

			override fun onHold() {

			}
		}

	}

	private fun setUpProgress() {
		binding.progressMax = imageList.size
		binding.progressPosition = 1
	}

	private fun updateStoriesView() {
		setImageType(imageList[imagePosition].url)
		setToolBar()
		loadImage()
		binding.progressPosition = imagePosition + 1
	}

	private fun setImageType(imageUrl: String) {
		imageType = if (imageUrl.contains(JPG, ignoreCase = true)) PHOTO
			else VIDEO
	}

	private fun setToolBar() {
		if (imageType == PHOTO) {
			binding.title = PHOTO
			binding.tvType.setBackgroundColor(context.getColor(R.color.color_primary_variant))
		} else {
			binding.title = VIDEO
			binding.tvType.setBackgroundColor(context.getColor(R.color.color_secondary_variant))
		}
	}

	private fun loadImage() {
		when (imageType) {
			PHOTO -> {
				binding.ivStories.visibility = View.VISIBLE
				binding.vvStories.visibility = View.GONE
				Glide.with(context)
					.load(imageList[imagePosition].url)
					.centerCrop()
					.error(R.drawable.ic_broken_image)
					.diskCacheStrategy(DiskCacheStrategy.RESOURCE)
					.into(binding.ivStories)
			}
			VIDEO -> {
				binding.ivStories.visibility = View.GONE
				binding.vvStories.visibility = View.VISIBLE

				val mc = MediaController(context)
				mc.setAnchorView(binding.vvStories)
				mc.setMediaPlayer(binding.vvStories)

				binding.vvStories.setMediaController(mc)
				binding.vvStories.setVideoURI(Uri.parse(imageList[imagePosition].largeUrl))
				binding.vvStories.start()
				binding.vvStories.setOnPreparedListener { it.isLooping = true }
			}
		}
	}

	companion object {
		const val PHOTO = "Photo"
		const val VIDEO = "Video"
		const val JPG = "JPG"
	}
}