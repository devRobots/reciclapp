package co.edu.uniquindio.reciclapp.model


class Usuario (var idCiudadano:Long, var nombres:String, var telefono:Long,
               var direccion: String, var correo: String, var contrasenia: String,
               var citasUsuario: ArrayList<Cita>){

    init {
        this.idCiudadano = idCiudadano
        this.nombres = nombres
        this.telefono = telefono
        this.direccion = direccion
        this.correo = correo
        this.contrasenia = contrasenia
    }
}