package by.tomal.domain.usecase.vehicle

import by.tomal.domain.entity.vehicle.Vehicle
import io.reactivex.Single

interface VehicleGetUseCase {
    fun get(): Single<List<Vehicle>>
}