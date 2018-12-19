package sobaya.app.mazdasearch

import android.app.Application
import org.koin.android.ext.android.startKoin
import org.koin.log.EmptyLogger
import sobaya.app.mazdasearch.di.module

class MazdaApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, module, logger = EmptyLogger())
    }
}