package co.edu.uniquindio.reciclapp.model

class Ciudadano(
    nombre: String,
    apellido: String?,
    tipoDocumento: TipoDocumento,
    numeroDocumento: String,
    telefono: String,
    correo: String,
    direccion: String
) : Persona(
    nombre, apellido, tipoDocumento, numeroDocumento, Rol.CIUDADANO, telefono, correo, direccion
)