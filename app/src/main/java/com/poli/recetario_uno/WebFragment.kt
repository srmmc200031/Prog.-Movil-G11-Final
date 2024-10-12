package com.poli.recetario_uno

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.SearchView
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.poli.recetario_uno.R

class WebFragment : Fragment() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var webView: WebView

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_web, container, false)

        val searchView = view.findViewById<SearchView>(R.id.searchView)
        val button = view.findViewById<Button>(R.id.btnSave)
        webView = view.findViewById(R.id.webView)

        // Configuración del WebView
        webView.settings.apply {
            javaScriptEnabled = true
            setSupportZoom(true)
            loadWithOverviewMode = true
            useWideViewPort = true
        }

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                if (url != null) {
                    view?.loadUrl(url)
                }
                return true
            }
        }

        button.setOnClickListener {
            val url = searchView.query.toString()
            webView.loadUrl(url)
        }

        drawerLayout = requireActivity().findViewById(R.id.drawer_layout)

        val buttonThreeDots: Button = view.findViewById(R.id.button_three_dots)
        buttonThreeDots.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return view
    }
}

