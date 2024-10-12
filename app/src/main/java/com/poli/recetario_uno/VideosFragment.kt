package com.poli.recetario_uno

import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.VideoView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.poli.recetario_uno.R

class VideosFragment : Fragment() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView


    private lateinit var videoView1: VideoView
    private lateinit var videoView2: VideoView
    private lateinit var videoView3: VideoView

    private lateinit var buttonPlay1: Button
    private lateinit var buttonPause1: Button
    private lateinit var buttonRewind1: Button
    private lateinit var buttonForward1: Button
    private lateinit var buttonFullScreen1: Button

    private lateinit var buttonPlay2: Button
    private lateinit var buttonPause2: Button
    private lateinit var buttonRewind2: Button
    private lateinit var buttonForward2: Button
    private lateinit var buttonFullScreen2: Button

    private lateinit var buttonPlay3: Button
    private lateinit var buttonPause3: Button
    private lateinit var buttonRewind3: Button
    private lateinit var buttonForward3: Button
    private lateinit var buttonFullScreen3: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el layout del fragmento
        val view = inflater.inflate(R.layout.fragment_videos, container, false)

        // Inicializa los VideoViews y botones
        videoView1 = view.findViewById(R.id.videoView1)
        videoView2 = view.findViewById(R.id.videoView2)
        videoView3 = view.findViewById(R.id.videoView3)

        buttonPlay1 = view.findViewById(R.id.buttonPlay1)
        buttonPause1 = view.findViewById(R.id.buttonPause1)
        buttonRewind1 = view.findViewById(R.id.buttonRewind1)
        buttonForward1 = view.findViewById(R.id.buttonForward1)
        buttonFullScreen1 = view.findViewById(R.id.buttonFullScreen1)

        buttonPlay2 = view.findViewById(R.id.buttonPlay2)
        buttonPause2 = view.findViewById(R.id.buttonPause2)
        buttonRewind2 = view.findViewById(R.id.buttonRewind2)
        buttonForward2 = view.findViewById(R.id.buttonForward2)
        buttonFullScreen2 = view.findViewById(R.id.buttonFullScreen2)

        buttonPlay3 = view.findViewById(R.id.buttonPlay3)
        buttonPause3 = view.findViewById(R.id.buttonPause3)
        buttonRewind3 = view.findViewById(R.id.buttonRewind3)
        buttonForward3 = view.findViewById(R.id.buttonForward3)
        buttonFullScreen3 = view.findViewById(R.id.buttonFullScreen3)

        // Establece las URLs de los videos (puedes usar tus propias URLs)
        val videoUri1 = Uri.parse("android.resource://${requireContext().packageName}/${R.raw.perrocaliente}")
        val videoUri2 = Uri.parse("android.resource://${requireContext().packageName}/${R.raw.hamburguesa}")
        val videoUri3 = Uri.parse("android.resource://${requireContext().packageName}/${R.raw.pastas}")

        videoView1.setVideoURI(videoUri1)
        videoView2.setVideoURI(videoUri2)
        videoView3.setVideoURI(videoUri3)

        // Configura los listeners
        buttonPlay1.setOnClickListener { videoView1.start() }
        buttonPause1.setOnClickListener { videoView1.pause() }
        buttonRewind1.setOnClickListener { rewindVideo(videoView1) }
        buttonForward1.setOnClickListener { forwardVideo(videoView1) }
        buttonFullScreen1.setOnClickListener { toggleFullScreen() }

        buttonPlay2.setOnClickListener { videoView2.start() }
        buttonPause2.setOnClickListener { videoView2.pause() }
        buttonRewind2.setOnClickListener { rewindVideo(videoView2) }
        buttonForward2.setOnClickListener { forwardVideo(videoView2) }
        buttonFullScreen2.setOnClickListener { toggleFullScreen() }

        buttonPlay3.setOnClickListener { videoView3.start() }
        buttonPause3.setOnClickListener { videoView3.pause() }
        buttonRewind3.setOnClickListener { rewindVideo(videoView3) }
        buttonForward3.setOnClickListener { forwardVideo(videoView3) }
        buttonFullScreen3.setOnClickListener { toggleFullScreen() }

        // Obtener el DrawerLayout de la actividad
        drawerLayout = requireActivity().findViewById(R.id.drawer_layout)

        // Configurar el botón de tres puntos
        val buttonThreeDots: Button = view.findViewById(R.id.button_three_dots)
        buttonThreeDots.setOnClickListener {
            // Abrir el Navigation Drawer
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return view // Devuelve la vista inflada
    }

    private fun rewindVideo(videoView: VideoView) {
        val currentPosition = videoView.currentPosition
        videoView.seekTo((currentPosition - 10000).coerceAtLeast(0)) // Retrocede 10 segundos
    }

    private fun forwardVideo(videoView: VideoView) {
        val currentPosition = videoView.currentPosition
        videoView.seekTo((currentPosition + 10000).coerceAtMost(videoView.duration)) // Adelanta 10 segundos
    }

    private fun toggleFullScreen() {
        // Cambia la orientación de la pantalla a pantalla completa usando la actividad
        activity?.requestedOrientation = if (activity?.requestedOrientation == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        } else {
            ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
    }
}
