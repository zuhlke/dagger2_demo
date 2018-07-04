package com.balsdon.dagger2demo

interface View

interface MainView : View {
    fun setText(text: String)
}