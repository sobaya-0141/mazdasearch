package sobaya.app.mazdasearch.ui.search

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.android.viewmodel.ext.android.viewModel
import sobaya.app.mazdasearch.R
import sobaya.app.mazdasearch.ext.observe
import sobaya.app.mazdasearch.ui.search.adapter.SearchAdapter

class SearchFragment: Fragment() {

    val searchViewModel: SearchViewModel by viewModel()
    val searchAdapter = SearchAdapter(null)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(R.layout.fragment_search, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        searchView.setOnQueryTextListener(searchViewModel.listener)
        recycler_search.apply {
            adapter = searchAdapter
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
        }
        searchViewModel.catalog.observe(this) {
            searchAdapter.items = it
            searchAdapter.notifyDataSetChanged()
        }
    }
}