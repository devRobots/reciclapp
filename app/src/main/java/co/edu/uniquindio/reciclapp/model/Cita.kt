package co.edu.uniquindio.reciclapp.model

import java.util.Date

data class Cita(
    var fecha: Date,
    var hora: String,
    var estado: EstadoCita,
    var calificacion: Double,
    var uidRecolector: String?,
    val uidCiudadano: String
)