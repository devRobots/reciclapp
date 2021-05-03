package co.edu.uniquindio.reciclapp.model

class Administrador (var idCiudadano:Long, var nombre:String, var apellido: String, var telefono:Long,
                     var direccion: String, var correo: String, var contrasenia: String,
                     var ventasAdmin: ArrayList<Venta>){

    init {
        this.idCiudadano = idCiudadano
        this.nombre = nombre
        this.apellido = apellido
        this.telefono = telefono
        this.direccion = direccion
        this.correo = correo
        this.contrasenia = contrasenia
    }
}