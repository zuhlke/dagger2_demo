package com.balsdon.dagger2demo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

interface PresenterDependent {
    fun presenter(presenter: MainPresenter)
}

class MainActivity : AppCompatActivity(), MainView, PresenterDependent {
    private lateinit var presenter : MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attach(this)
        buttonToClick.setOnClickListener { presenter.clicked() }
    }

    override fun setText(text: String) {
        buttonToClick.text = (getString(R.string.click_counter)).replace("0", text)
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }

    override fun presenter(presenter: MainPresenter) {
        this.presenter = presenter
        presenter.attach(this)
    }
}
