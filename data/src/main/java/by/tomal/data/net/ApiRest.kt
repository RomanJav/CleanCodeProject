package by.tomal.data.net

import by.tomal.cleancodeproject.data.entity.VehicleResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRest {

    @GET("car-service.php/")
    fun getVehicle(
        @Query("p1Lat") p1Lat: Double,
        @Query("p1Lon") p1Lon: Double,
        @Query("p2Lat") p2Lat: Double,
        @Query("p2Lon") p2Lon: Double
    ): Single<VehicleResponse>

}