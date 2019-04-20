package by.tomal.data.repository

import android.content.Context
import by.tomal.cleancodeproject.data.entity.responseToEntity
import by.tomal.data.db.AppDatabase
import by.tomal.data.rest.VehicleService
import by.tomal.domain.entity.exception.AppException
import by.tomal.domain.entity.exception.AppExceptionType
import by.tomal.domain.entity.vehicle.CoordinateParam
import by.tomal.domain.entity.vehicle.Vehicle
import by.tomal.domain.repository.vehicle.VehicleRepository
import io.reactivex.Single
import java.net.SocketTimeoutException

class VehicleRepositoryDefault(
    private val url: String,
    private val service: VehicleService,
    private val context: Context
) : VehicleRepository {

    private val vehicleDao = AppDatabase.create(context).getVehicleDao()

    override fun fetch(coords: Pair<CoordinateParam, CoordinateParam>): Single<List<Vehicle>> {

        return vehicleDao.get().flatMap {
            if (!it.isNullOrEmpty()) {
                Single.just(it)
            } else {
                service.requestData(coords).map { vehicles -> vehicles.poiList }
            }
        }.map { vehicleResponse ->
            vehicleResponse.map { it.responseToEntity() }
        }.onErrorResumeNext {
            when (it) {
                is SocketTimeoutException -> {
                    Single.error(AppException(AppExceptionType.NO_INTERNET))
                }
                else -> {
                    Single.error(AppException(AppExceptionType.UNKNOWN))
                }
            }
        }
    }
}