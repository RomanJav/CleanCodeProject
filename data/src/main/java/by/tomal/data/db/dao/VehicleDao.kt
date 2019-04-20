package by.tomal.data.db.dao

import android.arch.persistence.room.*
import by.tomal.cleancodeproject.data.entity.VehiclePoiResponse
import by.tomal.cleancodeproject.data.entity.vehicleTableId
import by.tomal.cleancodeproject.data.entity.vehicleTableName
import io.reactivex.Single

@Dao
interface VehicleDao {

    @Query("SELECT * FROM $vehicleTableName")
    fun get(): Single<List<VehiclePoiResponse>>

    @Query
        ("SELECT * FROM $vehicleTableName WHERE $vehicleTableId = :id LIMIT 1")
    fun getById(id: Int): Single<VehiclePoiResponse>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vehicles: List<VehiclePoiResponse>): Unit

    @Query("DELETE FROM $vehicleTableName")
    fun delete(): Unit
}