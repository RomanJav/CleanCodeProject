package by.tomal.cleancodeproject.data.entity

import by.tomal.domain.entity.vehicle.CoordinateParam
import by.tomal.domain.entity.vehicle.FleetType
import by.tomal.domain.entity.vehicle.Vehicle

fun VehiclePoiResponse.responseToEntity() =
    Vehicle(
        id,
        coordinate.responseToEntity(),
        FleetType.fromString(fleetType),
        heading
    )


fun CoordinateResponse.responseToEntity() = CoordinateParam(latitude, longitude)