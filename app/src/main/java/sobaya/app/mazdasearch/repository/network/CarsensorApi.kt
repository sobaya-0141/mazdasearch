package sobaya.app.mazdasearch.repository.network

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query
import sobaya.app.mazdasearch.data.network.dto.catalog.CatalogResponseDto

interface CarsensorApi {

    @GET("catalog/v1")
    fun catalogSearch(@Query("key") key: String, @Query("keyword") keyword: String,
                      @Query("brand") brand: String?, @Query("format") format: String): Flowable<CatalogResponseDto>
}
