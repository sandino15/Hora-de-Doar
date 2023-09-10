package com.example.gymfit2.Maps

import android.Manifest
import android.app.Notification.MessagingStyle.Message
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.gymfit2.Paginas.TreinoInferiores

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

import com.example.gymfit2.R
import com.example.gymfit2.databinding.ActivityMapsBinding
import com.google.android.gms.dtdi.analytics.Results
import com.google.firebase.auth.FirebaseAuth
import org.w3c.dom.Text
import java.security.Permission

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding
    private var Permissoes = arrayListOf<String>(Manifest.permission.ACCESS_FINE_LOCATION)
    private lateinit var validarPermissoes: Permissoes
    private lateinit var menssagem:Message
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Validar permissões




        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val Hemope = LatLng(-8.05280571939607, -34.89797131072538)
        //-8.05280571939607, -34.89797131072538

        mMap.setOnMapClickListener(GoogleMap.OnMapClickListener {
            fun onMapClick(latLng: LatLng) {
                var latitude = latLng.latitude;
                var longitude = latLng.longitude;


                mMap.addMarker(
                    MarkerOptions().position(latLng).title("Local").snippet("Descrição")
                )
            }
        })
        mMap.addMarker(MarkerOptions().position(Hemope).title("Hemope"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Hemope, 18F))

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray

    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

            for (i in grantResults.indices) {
                //permisão negada
                if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                //Alerta
                fun alertaValidacaoPermissao() {}

                }else(grantResults[i] == PackageManager.PERMISSION_GRANTED)
            }

        }

    }

