package com.example.sendmessage_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import com.example.sendmessage_2.model.Message
import com.example.sendmessage_2.model.Person

/**
 * Actividad principal que permite al usuario redactar y enviar un mensaje.
 *
 * Esta pantalla contiene:
 * <ul>
 *   <li>Un campo de texto (<b>EditText</b>) para redactar el mensaje.</li>
 *   <li>Un botón (<b>Button</b>) para iniciar el envío a la segunda pantalla.</li>
 * </ul>
 *
 * @author Carlos Nerí Campos Pérez
 * @version 1.0
 * @see ViewMessageActivity
 */
class SendMessageActivity : AppCompatActivity() {
    lateinit var editTextMessage: EditText
    lateinit var btSend: Button
    companion object {
        const val TAG: String = "LogSendMessageActivity"
    }
    /**
     * Inicializa la actividad y configura los eventos de los elementos gráficos.
     *
     * @param savedInstanceState Estado previo de la actividad si existiera.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_message)

        editTextMessage = findViewById(R.id.editTextMessage)
        btSend = findViewById(R.id.btSend)

        // Escuchador de clic en el botón para enviar datos
        btSend.setOnClickListener {
            /* Pasar dato a dato en un bundle
            val intent = Intent(this, ViewMessageActivity::class.java)
            val bundle = Bundle()
            bundle.putString("KEY_MESSAGE", editTextMessage.text.toString())
            intent.putExtras(bundle)
            startActivity(intent)
             */
            sendMessage()
        }
        Log.d("SendMessageActivity", "SendMessageActivity -> onCreate()")

    }

    /**
     * Función que crea un mensaje con la informacion de remitente y destinatario
     */
    private fun sendMessage() {
        // 1. Crear el intent
        val intent = Intent(this, ViewMessageActivity::class.java)
        // 2. Crear el bundle
        val bundle = Bundle()
        val sender= Person("12345678A", "Carlos", "Campos")
        val receiver = Person("89089012Z", "Lourdes", "Rodriguez")
        val message = Message(1, editTextMessage.text.toString(), sender, receiver)

        bundle.putSerializable("KEY_MESSAGE", message)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    //region Ciclo de Vida de una Actividad
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "SendMessageActivity -> onStart()")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "SendMessageActivity -> onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "SendMessageActivity -> onDestroy()")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "SendMessageActivity -> onPause()")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "SendMessageActivity -> onResume()")
    }
    //endregion
}