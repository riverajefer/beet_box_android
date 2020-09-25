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
        const val CLAP = "clap"
        const val CYMBAL = "cymbal"
        const val KICK = "kick"
        const val OPEN = "open"
        const val SNARE = "snare"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.text_view_id) as TextView

        getFirebaseSoundClap()
        getFirebaseSoundCymbal()
        getFirebaseSoundKick()
        getFirebaseSoundOpen()
        getFirebaseSoundSnare()
    }

    fun getFirebaseSoundClap() {
        val refSonidoClap =  refSonidos.child(DbConstants.CLAP)

        refSonidoClap.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.value
                Log.d("Main", "Value sonido 1: $value")
                if (value == true) {
                    playSoundClap()
                    textView.text = DbConstants.CLAP.toUpperCase()
                    refSonidoClap.setValue(false)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Log.w("Main", "Failed to read value sonido 1.", error.toException())
            }
        })
    }

    fun getFirebaseSoundCymbal() {
        val refSonidoCymbal =  refSonidos.child(DbConstants.CYMBAL)

        refSonidoCymbal.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.value
                Log.d("Main", "Value sonido 2: $value")
                if (value == true) {
                    playSoundCymbal()
                    textView.text = DbConstants.CYMBAL.toUpperCase()
                    refSonidoCymbal.setValue(false)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Log.w("Main", "Failed to read value sonido 1.", error.toException())
            }
        })
    }

    fun getFirebaseSoundKick() {
        val refSonidoKick =  refSonidos.child(DbConstants.KICK)

        refSonidoKick.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.value
                Log.d("Main", "Value sonido 3: $value")
                if (value == true) {
                    playSoundKick()
                    textView.text = DbConstants.KICK.toUpperCase()
                    refSonidoKick.setValue(false)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Log.w("Main", "Failed to read value sonido 1.", error.toException())
            }
        })
    }

    fun getFirebaseSoundOpen() {
        val refSonidoOpen =  refSonidos.child(DbConstants.OPEN)

        refSonidoOpen.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.value
                Log.d("Main", "Value sonido 3: $value")
                if (value == true) {
                    playSoundOpen()
                    textView.text = DbConstants.OPEN.toUpperCase()
                    refSonidoOpen.setValue(false)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Log.w("Main", "Failed to read value sonido 1.", error.toException())
            }
        })
    }

    fun getFirebaseSoundSnare() {
        val refSonidoSnare =  refSonidos.child(DbConstants.SNARE)

        refSonidoSnare.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.value
                Log.d("Main", "Value sonido 3: $value")
                if (value == true) {
                    playSoundSnare()
                    textView.text = DbConstants.SNARE.toUpperCase()
                    refSonidoSnare.setValue(false)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Log.w("Main", "Failed to read value sonido 1.", error.toException())
            }
        })
    }

    fun playSoundClap() {
        mediaPlayer = MediaPlayer.create(this, R.raw.clap)
        mediaPlayer?.start()
    }

    fun playSoundCymbal() {
        mediaPlayer = MediaPlayer.create(this, R.raw.cymbal)
        mediaPlayer?.start()
    }

    fun playSoundKick() {
        mediaPlayer = MediaPlayer.create(this, R.raw.kick)
        mediaPlayer?.start()
    }
    fun playSoundOpen() {
        mediaPlayer = MediaPlayer.create(this, R.raw.open)
        mediaPlayer?.start()
    }
    fun playSoundSnare() {
        mediaPlayer = MediaPlayer.create(this, R.raw.snare)
        mediaPlayer?.start()
    }
}
