package com.balsdon.dagger2demo

abstract class Presenter(val view: View)

class MainPresenter(private val mainView: MainView) : Presenter(mainView) {
    private var counter = 0

    fun clicked() {
        counter++
        mainView.setText(counter.toString())
    }
}
