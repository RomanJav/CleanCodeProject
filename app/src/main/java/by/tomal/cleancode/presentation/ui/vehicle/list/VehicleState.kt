package by.tomal.cleancode.presentation.ui.vehicle.list

import by.tomal.domain.entity.vehicle.Vehicle

sealed class VehicleState {

    object Progress : VehicleState()
    class Done(val vehicleList: List<Vehicle>) : VehicleState()
    class Error(val throwable: Throwable) : VehicleState()

}