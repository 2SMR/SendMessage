package com.example.sendmessage_2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Clase de datos que representa a una persona dentro del sistema.
 *
 * Implementa [Parcelable] para permitir el envío de sus instancias
 * entre componentes de Android a través de un [android.os.Bundle].
 *
 * @property dni Documento Nacional de Identidad o identificador único de la persona.
 * @property name Nombre de la persona.
 * @property surname Apellidos de la persona.
 *
 * @author Carlos Nerí Campos Pérez
 * @version 1.0
 */
@Parcelize
data class Person(
    val dni: String,
    val name: String,
    val surname: String
) : Parcelable