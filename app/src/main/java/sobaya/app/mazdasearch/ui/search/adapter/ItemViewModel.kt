package sobaya.app.mazdasearch.ui.search.adapter

import sobaya.app.mazdasearch.data.network.dto.catalog.CatalogDto

class ItemViewModel(val catalog: CatalogDto) {

    val image = catalog.photo.front.s
    val name = catalog.model
    val price = "${String.format("%, d", catalog.price)}円"
    val desc = catalog.desc
    val grade = catalog.grade
}