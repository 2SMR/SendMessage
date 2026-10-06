package com.example.sendmessage_2

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat
import com.example.sendmessage_2.model.Message

/**
 * Actividad secundaria que muestra el mensaje recibido desde [SendMessageActivity].
 *
 * Muestra el mensaje en un <b>TextView</b> junto con una imagen vectorial de confirmación.
 *
 * @author Carlos Nerí Campos Pérez
 * @version 1.0
 * @see SendMessageActivity
 */
class ViewMessageActivity : AppCompatActivity() {
    companion object {
        const val TAG: String = "LogViewMessageActivity"
    }

    /**
     * Inicializa la pantalla y recupera los datos enviados en el Intent.
     *
     * @param savedInstanceState Estado de la instancia guardada.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_message)

        val tvMessage = findViewById<TextView>(R.id.textViewReceivedMessage)

        // Recuperamos el objeto Message usando IntentCompat para mayor compatibilidad (Android 13+)
        val message = IntentCompat.getParcelableExtra(intent, "KEY_MESSAGE", Message::class.java)

        message?.let {
            val senderName = "${it.sender.name} ${it.sender.surname}"
            tvMessage.text = "De: $senderName\n\nMensaje:\n${it.content}"
        }
    }

    //region Ciclo de Vida de una Actividad
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "ViewMessageActivity -> onStart()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "ViewMessageActivity -> onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "ViewMessageActivity -> onDestroy()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "ViewMessageActivity -> onPause()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "ViewMessageActivity -> onResume()")
    }
    //endregion
}