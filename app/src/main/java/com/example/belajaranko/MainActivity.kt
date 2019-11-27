package com.example.belajaranko

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
    }

    class MainActivityUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout {
                padding = dip(16)
                val name = editText {
                    hint = "Input your name"
                }

                button("Hello") {
                    textColor = Color.WHITE
                    setOnClickListener { toast("Hello My Name is ${name.text}!") }
                }.lparams(width = matchParent) {
                    topMargin = dip(5)
                }

                button("Show Alert") {
                    textColor = Color.WHITE


                    setOnClickListener {
                        alert("Hi ${name.text}, welcome to app") {
                            yesButton { toast("Thanks..") }

                            noButton {}
                        }.show()
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }

                button("Show Selector"){
                    textColor = Color.WHITE

                    setOnClickListener{
                        val club = listOf("Barcelona", "Real Madrid", "Madura United")
                        selector("Hello, ${name.text}! What's football club do you love?", club){ _, i ->
                            toast("So you love ${club[i]}, right?")
                        }
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }

                button("Show Snackbar"){
                    textColor = Color.WHITE

                    setOnClickListener {
                        snackbar("Hi, ${name.text}")
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }

                button("Go to Second Activity") {
                    textColor = Color.WHITE

                    setOnClickListener {
                        startActivity<SecondActivity>("name" to "${name.text}")
                    }
                }.lparams(width = matchParent){
                    topMargin = dip(5)
                }
            }
        }
    }
}
