package by.tomal.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import by.tomal.cleancodeproject.data.entity.VehiclePoiResponse
import by.tomal.data.db.dao.VehicleDao

@Database(entities = [VehiclePoiResponse::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        private const val DB_NAME = "vehiclesDb"

        fun create(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                DB_NAME
            ).build()
        }
    }

    abstract fun getVehicleDao(): VehicleDao
}