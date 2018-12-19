package sobaya.app.mazdasearch.ui.search.adapter

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import sobaya.app.mazdasearch.R
import sobaya.app.mazdasearch.data.network.dto.catalog.CatalogDto

class SearchAdapter(var items: List<CatalogDto>?): RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SearchViewHolder(
        DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.adapter_search, parent, false)
    )

    override fun getItemCount() = items?.size?: 0

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {

        holder.binding.itemViewModel = ItemViewModel(items?.get(position)!!)
    }

    inner class SearchViewHolder(val binding: sobaya.app.mazdasearch.databinding.AdapterSearchBinding): RecyclerView.ViewHolder(binding.root)
}