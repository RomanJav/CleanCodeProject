package by.tomal.cleancode.app

import by.tomal.cleancode.BuildConfig
import by.tomal.data.repository.VehicleRepositoryDefault
import by.tomal.data.rest.VehicleService
import by.tomal.domain.usecase.vehicle.VehicleGetUseCase
import by.tomal.domain.usecase.vehicle.VehicleGetUseCaseDefault
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object UseCaseProvider {

    fun provideGetVehicleuseCase(): VehicleGetUseCase {
        return VehicleGetUseCaseDefault(
            getWorkScheduler(),
            getPostScheduler(),
            VehicleRepositoryDefault(
                BuildConfig.API_ENDPOINT,
                VehicleService(VehicleApplication.instance.applicationContext),
                VehicleApplication.instance.applicationContext
            )
        )
    }

    private fun getWorkScheduler() = Schedulers.io()

    private fun getPostScheduler() = AndroidSchedulers.mainThread()

}