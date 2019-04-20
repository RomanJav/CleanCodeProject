package by.tomal.domain.entity.vehicle

import by.tomal.domain.entity.DomainEntity

data class Vehicle(val id: Int, val coordinateParam: CoordinateParam, val fleetType: FleetType, val heading: Double) :
    DomainEntity