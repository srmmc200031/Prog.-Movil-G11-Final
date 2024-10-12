package com.poli.recetario_uno


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.findNavController
import com.google.android.material.navigation.NavigationView

class InicioFragment : Fragment() {

    private lateinit var navigationView: NavigationView
    private lateinit var drawerLayout: DrawerLayout



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_inicio, container, false)

        val btnInvitado = root.findViewById<Button>(R.id.btnInvitado)
        //drawerLayout = requireActivity().findViewById(R.id.drawer_layout)
      //  navigationView = requireActivity().findViewById(R.id.nav_view)

        btnInvitado.setOnClickListener {
            // Usar el navController para navegar
            findNavController().navigate(R.id.menuFragment2)
        }

        return root

    }
}