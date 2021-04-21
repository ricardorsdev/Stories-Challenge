package br.com.ricardorsdev.storieschallenge.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(
	var id: Int,
	var url: String,
	@SerializedName("large_url") var largeUrl: String,
	@SerializedName("source_id") var sourceId: Int?
) : Parcelable