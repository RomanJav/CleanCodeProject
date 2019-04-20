package by.tomal.domain.repository.vehicle

import by.tomal.domain.entity.vehicle.CoordinateParam
import by.tomal.domain.entity.vehicle.Vehicle
import io.reactivex.Single

interface VehicleRepository {
    fun fetch(coords: Pair<CoordinateParam, CoordinateParam>) : Single<List<Vehicle>>
}