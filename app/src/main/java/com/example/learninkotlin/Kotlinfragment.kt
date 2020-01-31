package com.example.learninkotlin


import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


/**
 * A simple [Fragment] subclass.
 */
class Kotlinfragment : Fragment() {

    val HOME = "https://www.payoneer.com/"
    private var mProgressBar: ProgressBar? = null

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_kotlinfragment, container, false)

        val mWeb: WebView = view.findViewById(R.id.web)
        val activity = activity as AppCompatActivity?
        val bar: Toolbar = view.findViewById(R.id.toolbar)
        activity?.setSupportActionBar(bar)
        val actionBar = activity?.supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        mProgressBar = view.findViewById(R.id.progressBar)
        mProgressBar?.max=100
        mWeb.settings.javaScriptEnabled = true

        mWeb.setWebChromeClient(object : WebChromeClient() {
            override fun onProgressChanged(webView: WebView, newProgress: Int) {
                if (newProgress == 100) {
                    mProgressBar?.visibility = View.GONE
                } else {
                    mProgressBar?.visibility = View.VISIBLE
                    mProgressBar?.progress = newProgress
                }
            }

            override fun onReceivedTitle(webView: WebView, title: String) {
                activity?.supportActionBar!!.subtitle = title
            }
        })

        mWeb.webViewClient = WebViewClient()
        mWeb.loadUrl(HOME)

        return view
    }





}
