package com.poli.recetario_uno

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.Button
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView


class PerfilesFragment : Fragment() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el layout del fragmento
        val view = inflater.inflate(R.layout.fragment_perfiles, container, false)

        // Obtén el DrawerLayout
        drawerLayout = requireActivity().findViewById(R.id.drawer_layout)

        // Encuentra el botón en el layout inflado
        val buttonThreeDots: Button = view.findViewById(R.id.button_three_dots)
        buttonThreeDots.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        // Retorna el view inflado
        return view
    }
}
