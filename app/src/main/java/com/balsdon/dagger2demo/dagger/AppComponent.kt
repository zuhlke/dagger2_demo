package com.balsdon.dagger2demo.dagger

import com.balsdon.dagger2demo.MainActivity
import com.balsdon.dagger2demo.MainPresenter
import com.balsdon.dagger2demo.MainView
import com.balsdon.dagger2demo.Presenter
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(modules = [(ApplicationModule::class)])
interface AppComponent {
    fun inject(target: MainActivity)
}

@Module
class ApplicationModule {
    @Provides
    @ActivityScope
    internal fun providesMainPresenter(): Presenter<MainView> {
        return MainPresenter()
    }
}
