package com.poli.recetario_uno

import androidx.navigation.NavController

import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.poli.recetario_uno.WebFragment
import com.google.android.material.navigation.NavigationView
import androidx.navigation.fragment.NavHostFragment



class MainActivity : AppCompatActivity() {



    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as? NavHostFragment
        val navController = navHostFragment?.navController ?: return


        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.nav_view)

        // Cargar el fragmento inicial solo si no hay un estado guardado
        if (savedInstanceState == null) {
            navController.navigate(R.id.inicioFragment) // Carga el fragmento predeterminado
        }

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_videos -> {
                    navigateAndCloseDrawer(navController, R.id.videosFragment)
                    true
                }
                R.id.nav_inicio -> {
                    navigateAndCloseDrawer(navController, R.id.inicioFragment)
                    true
                }
                R.id.nav_galeria -> {
                    navigateAndCloseDrawer(navController, R.id.recetarioFragment)
                    true
                }
                R.id.nav_web -> {
                    navigateAndCloseDrawer(navController, R.id.webFragment)
                    true
                }
                R.id.nav_perfiles -> {
                    navigateAndCloseDrawer(navController, R.id.perfilesFragment)
                    true
                }
                R.id.nav_menu -> {
                    navController.navigate(R.id.menuFragment2) // Deja el drawer abierto
                    true
                }
                else -> false
            }
        }
    }

    private fun navigateAndCloseDrawer(navController: NavController, destinationId: Int) {
        navController.navigate(destinationId)
        drawerLayout.closeDrawers() // Cierra el drawer
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack() // Regresa al fragmento anterior
        } else {
            super.onBackPressed() // Comportamiento normal del botón de retroceso
        }
    }
}
