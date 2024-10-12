package com.poli.recetario_uno

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.findNavController

class RecetarioFragment : Fragment() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var textView1: TextView
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView
    private lateinit var textView4: TextView
    private lateinit var textView5: TextView
    private lateinit var textView6: TextView
    private lateinit var textView7: TextView
    private lateinit var textView8: TextView




    // Agrega más TextViews según sea necesario
    private var isSelected1 = false
    private var isSelected2 = false
    private var isSelected3 = false
    private var isSelected4 = false
    private var isSelected5 = false
    private var isSelected6 = false
    private var isSelected7 = false
    private var isSelected8 = false

    // Agrega más variables de estado según sea necesario

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout para este fragmento
        val view = inflater.inflate(R.layout.fragment_recetario, container, false)



        // Encontrar los botones y TextViews en la vista inflada
        val button1 = view.findViewById<ImageView>(R.id.arepa_btn)
        textView1 = view.findViewById<TextView>(R.id.txt_descripcion1)

        val button2 = view.findViewById<ImageView>(R.id.sopa_btn) // otro botón
        textView2 = view.findViewById<TextView>(R.id.txt_descripcion2) // otro TextView

        val button3 = view.findViewById<ImageView>(R.id.hambuerguesa_btn) // otro botón
        textView3 = view.findViewById<TextView>(R.id.txt_descripcion) // otro TextView

        val button4 = view.findViewById<ImageView>(R.id.perro_btn) // otro botón
        textView4 = view.findViewById<TextView>(R.id.txt_descripcion4) // otro TextView

        val button5 = view.findViewById<ImageView>(R.id.pastas_btn) // otro botón
        textView5 = view.findViewById<TextView>(R.id.txt_descripcion5) // otro TextView

        val button6 = view.findViewById<ImageView>(R.id.carne_btn) // otro botón
        textView6 = view.findViewById<TextView>(R.id.txt_descripcion6) // otro TextView

        val button7 = view.findViewById<ImageView>(R.id.pescado_btn) // otro botón
        textView7 = view.findViewById<TextView>(R.id.descripcion7) // otro TextView

        val button8 = view.findViewById<ImageView>(R.id.arroz_btn) // otro botón
        textView8 = view.findViewById<TextView>(R.id.descripcion8) // otro TextView


        // Ocultar los TextViews inicialmente
        textView1.visibility = View.GONE
        textView2.visibility = View.GONE
        textView3.visibility = View.GONE
        textView4.visibility = View.GONE
        textView5.visibility = View.GONE
        textView6.visibility = View.GONE
        textView7.visibility = View.GONE
        textView8.visibility = View.GONE

        // Establecer el OnClickListener para el primer botón
        button1.setOnClickListener {
            toggleVisibility(textView1, isSelected1)
            isSelected1 = !isSelected1
        }

        // Establecer el OnClickListener para el segundo botón
        button2.setOnClickListener {
            toggleVisibility(textView2, isSelected2)
            isSelected2 = !isSelected2
        }
// Establecer el OnClickListener para el tercer botón
        button3.setOnClickListener {
            toggleVisibility(textView3, isSelected3)
            isSelected3 = !isSelected3
        }
// Establecer el OnClickListener para el cuarto botón
        button4.setOnClickListener {
            toggleVisibility(textView4, isSelected4)
            isSelected4 = !isSelected4
        }

        // Establecer el OnClickListener para el quinto botón
        button5.setOnClickListener {
            toggleVisibility(textView5, isSelected5)
            isSelected5 = !isSelected5
        }

        // Establecer el OnClickListener para el sexto botón
        button6.setOnClickListener {
            toggleVisibility(textView6, isSelected6)
            isSelected6 = !isSelected6
        }
        // Establecer el OnClickListener para el septimo botón
        button7.setOnClickListener {
            toggleVisibility(textView7, isSelected7)
            isSelected7 = !isSelected7
        }
        // Establecer el OnClickListener para el octavo botón
        button8.setOnClickListener {
            toggleVisibility(textView8, isSelected8)
            isSelected8 = !isSelected8

        }

        // Obtener el DrawerLayout de la actividad
        drawerLayout = requireActivity().findViewById(R.id.drawer_layout)

        // Configurar el botón de tres puntos
        val buttonThreeDots: Button = view.findViewById(R.id.button_three_dots)
        buttonThreeDots.setOnClickListener {
            // Abrir el Navigation Drawer
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return view
    }

    private fun toggleVisibility(textView: TextView, isSelected: Boolean) {
        if (isSelected) {
            textView.visibility = View.GONE

        } else {
            textView.visibility = View.VISIBLE

        }
    }
}
