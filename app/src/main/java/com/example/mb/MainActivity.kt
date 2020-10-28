package com.example.mb

import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

@Suppress("SpellCheckingInspection")

class MainActivity : AppCompatActivity() {

    var mediaPlayer = MediaPlayer()
    var database = Firebase.database
    var refSonidos = database.getReference(DbConstants.SONIDOS)
    lateinit var textView: TextView

    object DbConstants {
        const val SONIDOS = "sonidos"
        const val ARROZ = "arroz"
        const val CREMA = "crema"
        const val GASEOSA = "gaseosa"
        const val PAPEL = "papel"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.text_view_id) as TextView

        getFirebaseSoundArroz()
        getFirebaseSoundCrema()
        getFirebaseSoundGaseosa()
        getFirebaseSoundPapel()
    }

    fun getFirebaseSoundArroz() {
        val refSonidoArroz =  refSonidos.child(DbConstants.ARROZ)

        refSonidoArroz.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.value
                Log.d("Main", "Value sonido arroz: $value")
                if (value == true) {
                    playSoundArroz()
                    textView.text = DbConstants.ARROZ.toUpperCase()
                    refSonidoArroz.setValue(false)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Log.w("Main", "Failed to read value sonido 1.", error.toException())
            }
        })
    }

    fun getFirebaseSoundCrema() {
        val refSonidoCrema =  refSonidos.child(DbConstants.CREMA)

        refSonidoCrema.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.value
                Log.d("Main", "Value sonido 2: $value")
                if (value == true) {
                    playSoundCrema()
                    textView.text = DbConstants.CREMA.toUpperCase()
                    refSonidoCrema.setValue(false)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Log.w("Main", "Failed to read value sonido 1.", error.toException())
            }
        })
    }

    fun getFirebaseSoundGaseosa() {
        val refSonidoGaseosa =  refSonidos.child(DbConstants.GASEOSA)

        refSonidoGaseosa.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.value
                Log.d("Main", "Value sonido 3: $value")
                if (value == true) {
                    playSoundGaseosa()
                    textView.text = DbConstants.GASEOSA.toUpperCase()
                    refSonidoGaseosa.setValue(false)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Log.w("Main", "Failed to read value sonido 1.", error.toException())
            }
        })
    }

    fun getFirebaseSoundPapel() {
        val refSonidoPapel =  refSonidos.child(DbConstants.PAPEL)

        refSonidoPapel.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.value
                Log.d("Main", "Value sonido 3: $value")
                if (value == true) {
                    playSoundPapel()
                    textView.text = DbConstants.PAPEL.toUpperCase()
                    refSonidoPapel.setValue(false)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Log.w("Main", "Failed to read value sonido 1.", error.toException())
            }
        })
    }

    fun playSoundArroz() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop()
            mediaPlayer.reset()
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.arroz)
        mediaPlayer?.start()
    }

    fun playSoundCrema() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop()
            mediaPlayer.reset()
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.crema)
        mediaPlayer?.start()
    }

    fun playSoundGaseosa() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop()
            mediaPlayer.reset()
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.gaseosa)
        mediaPlayer?.start()
    }

    fun playSoundPapel() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.stop()
            mediaPlayer.reset()
        }
        mediaPlayer = MediaPlayer.create(this, R.raw.papel)
        mediaPlayer?.start()
    }

}
