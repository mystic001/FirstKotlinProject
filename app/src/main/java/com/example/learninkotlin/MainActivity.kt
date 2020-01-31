package com.example.learninkotlin

import androidx.fragment.app.Fragment


class MainActivity : SingleFramentActivity() {
    override fun createFragment(): Fragment {

        return Kotlinfragment()
    }


}
