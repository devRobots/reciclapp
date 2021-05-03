package co.edu.uniquindio.reciclapp.model

import java.util.*

class Cita (var idCita: Long, var fecha:Date, var hora:String, var estado:EstadoCita,
            var calificacion: Long, var cantidadMaterial: Long, var usuario: Usuario,
            var recolector: Recolector) {
}