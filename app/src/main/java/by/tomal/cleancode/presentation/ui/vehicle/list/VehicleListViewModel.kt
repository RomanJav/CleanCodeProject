package by.tomal.cleancode.presentation.ui.vehicle.list

import android.arch.lifecycle.MutableLiveData
import android.widget.Toast
import by.tomal.cleancode.app.VehicleApplication
import by.tomal.cleancode.presentation.base.BaseViewModel
import by.tomal.domain.entity.exception.AppException
import by.tomal.domain.entity.vehicle.Vehicle
import by.tomal.domain.usecase.vehicle.VehicleGetUseCase

class VehicleListViewModel(vehiclesListUseCase: VehicleGetUseCase) : BaseViewModel() {

    val vehicleState = MutableLiveData<VehicleState>()
    val vehicleClicked = MutableLiveData<Vehicle>()

    init {
        vehicleState.value = VehicleState.Progress
        val disposable = vehiclesListUseCase.get().subscribe({
            vehicleState.value = VehicleState.Done(it)
        }, {
            if(it is AppException) {
                performExceptionTypeAction(it)
            } else {

            }
            vehicleState.value = VehicleState.Error(it)
        })
        disposableBag.add(disposable)
    }

    private fun performExceptionTypeAction(it: AppException) {
        Toast.makeText(VehicleApplication.instance.applicationContext, "Exception occurred: $it", Toast.LENGTH_LONG).show()
    }

    fun vehicleClick(vehicle: Vehicle) {
        vehicleClicked.value = vehicle
    }

}