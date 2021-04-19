package br.com.ricardorsdev.storieschallenge.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.ricardorsdev.storieschallenge.data.entities.ImageEntity

@Dao
interface ImageDao {
	@Insert(onConflict = OnConflictStrategy.REPLACE)
	fun insertAll(vararg imageEntities: ImageEntity)

	@Query("SELECT * FROM imageEntity")
	fun getAll(): List<ImageEntity>
}