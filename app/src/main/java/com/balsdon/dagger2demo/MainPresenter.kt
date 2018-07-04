package com.balsdon.dagger2demo

abstract class Presenter<T : View> {
    var view: T? = null

    fun attach(view: T) {
        this.view = view
    }

    fun detach() {
        view = null
    }
}

class MainPresenter : Presenter<MainView>() {
    private var counter = 0

    fun clicked() {
        counter++
        view?.setText(counter.toString())
    }
}
