package sobaya.app.mazdasearch.data.network.dto.catalog

import com.squareup.moshi.Json

data class ResultsDto(
    @Json(name = "results_available")
    val available: Int,
    @Json(name = "results_returned")
    val returned: Int,
    val catalog: List<CatalogDto>
)