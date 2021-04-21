package br.com.ricardorsdev.storieschallenge.data

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.ricardorsdev.storieschallenge.data.dao.ImageDao
import br.com.ricardorsdev.storieschallenge.data.entities.ImageEntity
import br.com.ricardorsdev.storieschallenge.util.Constants


@Database(
	entities = [ImageEntity::class],
	version = Constants.DB_VERSION_CODE,
	exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
	abstract fun imageDao(): ImageDao
}