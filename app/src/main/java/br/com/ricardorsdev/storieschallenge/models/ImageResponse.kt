package br.com.ricardorsdev.storieschallenge.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImageResponse(
	var images: List<Image>
) : Parcelable
