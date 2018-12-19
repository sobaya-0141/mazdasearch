package sobaya.app.mazdasearch.data.network.dto.catalog

import com.squareup.moshi.Json

data class CatalogRequestDto(
    val key: String,
    val keyword: String?,
    @Json(name = "year_old")
    val yearOld: Int?,
    @Json(name = "year_new")
    val yearNew: Int?,
    val format: String
)