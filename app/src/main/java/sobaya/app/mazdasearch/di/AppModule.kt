package sobaya.app.mazdasearch.di

import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import sobaya.app.mazdasearch.repository.CarRepository
import sobaya.app.mazdasearch.repository.CarRepositoryImpl
import sobaya.app.mazdasearch.ui.search.SearchViewModel

val module = listOf(
    module {
        viewModel { SearchViewModel(get()) }
        factory<CarRepository> { CarRepositoryImpl(get()) }
    }
) + listOf(remoteModule)