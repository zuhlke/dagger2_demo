package com.balsdon.dagger2demo

import android.app.Application
import com.balsdon.dagger2demo.dagger.AppComponent
import com.balsdon.dagger2demo.dagger.DaggerAppComponent


class MainApplication : Application() {
    companion object{
        @JvmStatic lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        initDagger()
    }

    private fun initDagger() {
        appComponent = DaggerAppComponent
                .builder()
                // deprecated. yay. more fun finding the up2date docs
                // even more fun discovering this is generated code
                // i.e. it generates this deprecation
                // good news: don't need it
                // .applicationModule(ApplicationModule())
                .build()
    }
}
