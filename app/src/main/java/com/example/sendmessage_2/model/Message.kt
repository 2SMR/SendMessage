package com.example.sendmessage_2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Clase de datos que representa un mensaje enviado entre dos usuarios.
 *
 * Implementa [Parcelable] para poder transmitir la información del mensaje
 * y sus objetos embebidos ([Person]) entre actividades.
 *
 * @property id Identificador único del mensaje.
 * @property content Texto o cuerpo del mensaje enviado.
 * @property sender Objeto [Person] que emite el mensaje (remitente).
 * @property receiver Objeto [Person] que recibe el mensaje (destinatario).
 *
 * @author Carlos Nerí Campos Pérez
 * @version 1.0
 * @see Person
 */
@Parcelize
data class Message(
    val id: Int,
    val content: String,
    val sender: Person,
    val receiver: Person
) : Parcelable