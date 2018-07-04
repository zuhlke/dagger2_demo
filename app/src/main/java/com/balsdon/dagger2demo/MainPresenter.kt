package com.balsdon.dagger2demo

import javax.inject.Inject

abstract class Presenter<T: View> {
    var view: T? = null

    fun attach(view: T) {
        this.view = view
    }

    fun detach() {
        view = null
    }
}

//Heaven forbid you forget the @Inject constructor
class MainPresenter @Inject constructor() : Presenter<MainView>() {

    private var counter = 0

    fun clicked() {
        counter++
        view?.setText(counter.toString())
    }
}
