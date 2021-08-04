package co.edu.uniquindio.reciclapp.model

class Recolector(
    nombre: String,
    apellido: String?,
    tipoDocumento: TipoDocumento,
    numeroDocumento: String,
    telefono: String,
    correo: String,
    direccion: String
) : Persona(
    nombre, apellido, tipoDocumento, numeroDocumento, Rol.NO_USUARIO, telefono, correo, direccion
){
    constructor() :this("",null,TipoDocumento.CEDULA,"","","","")
}