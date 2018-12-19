package sobaya.app.mazdasearch.ui.search

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Intent
import android.net.Uri
import android.support.v4.content.ContextCompat.startActivity
import android.view.View
import android.widget.SearchView
import io.reactivex.schedulers.Schedulers
import sobaya.app.mazdasearch.data.network.dto.catalog.CatalogDto
import sobaya.app.mazdasearch.repository.CarRepository

class SearchViewModel(private val carRepository: CarRepository): ViewModel() {

    val listener = object: SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            if (query != null)
                search(query)
            return true
        }
        override fun onQueryTextChange(newText: String?) = true
    }

    val catalog = MutableLiveData<List<CatalogDto>>()

    fun search(keyword: String) {

        carRepository.catalogSearch(keyword)
            .observeOn(Schedulers.io())
            .subscribeOn(Schedulers.io())
            .subscribe(
                {
                    catalog.postValue(it.results.catalog)
                },
                {
                    it.toString()
                })
    }

    fun onClickCarsensor(view: View) {
        val uri = Uri.parse("http://webservice.recruit.co.jp")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(view.context, intent, null)
    }
}