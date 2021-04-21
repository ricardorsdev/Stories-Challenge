package br.com.ricardorsdev.storieschallenge.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ImageEntity(
	@PrimaryKey val id: Int,
	val url: String,
	@ColumnInfo(name = "large_url") val largeUrl: String
)
