package by.tomal.cleancode.presentation.ui.vehicle.list

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import by.tomal.cleancode.app.UseCaseProvider

class VehicleListViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return VehicleListViewModel(
            UseCaseProvider
                .provideGetVehicleuseCase()
        ) as T
    }
}