package by.tomal.data.rest

import android.content.Context
import by.tomal.cleancodeproject.data.entity.VehicleResponse
import by.tomal.data.db.AppDatabase
import by.tomal.data.net.provideApi
import by.tomal.domain.entity.vehicle.CoordinateParam
import io.reactivex.Single
import io.reactivex.disposables.Disposable

class VehicleService(context: Context) {

    private val vehicleDao = AppDatabase.create(context).getVehicleDao()
    private val api = provideApi()
    private var disposable: Disposable? = null

    @Throws(Exception::class)
    fun requestData(coords: Pair<CoordinateParam, CoordinateParam>): Single<VehicleResponse> {
        val vehicleResponse = api.getVehicle(coords.first.lat, coords.first.long, coords.second.lat, coords.second.long)

        disposable = vehicleResponse
            .subscribe { response ->
                run {
                    disposable?.let {
                        if (!it.isDisposed) {
                            it.dispose()
                        }
                    }
                }
                vehicleDao.insert(response.poiList ?: arrayListOf())
            }


        return vehicleResponse
    }
}