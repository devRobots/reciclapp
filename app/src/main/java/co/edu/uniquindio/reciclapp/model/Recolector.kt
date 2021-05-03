package co.edu.uniquindio.reciclapp.model

class Recolector (var idRecolector: Long, var nombre: String, var telefono: Long, var correo: String,
                  var citasRecolector: ArrayList<Cita>) {

    init{
        this.idRecolector = idRecolector
        this.nombre = nombre
        this.telefono = telefono
        this.correo = correo
    }
}