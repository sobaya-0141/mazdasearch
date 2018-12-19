package sobaya.app.mazdasearch.repository

import io.reactivex.Flowable
import sobaya.app.mazdasearch.data.network.dto.catalog.CatalogResponseDto
import sobaya.app.mazdasearch.repository.network.CarsensorApi

interface CarRepository {
    fun catalogSearch(keyword: String): Flowable<CatalogResponseDto>
}

class CarRepositoryImpl(private val api: CarsensorApi): CarRepository {

    override fun catalogSearch(keyword: String) = api.catalogSearch("API_KEY", keyword, "MA","json")
}