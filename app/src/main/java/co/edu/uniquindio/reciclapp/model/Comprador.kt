package co.edu.uniquindio.reciclapp.model

class Comprador(
    nombre: String,
    apellido: String?,
    tipoDocumento: TipoDocumento,
    numeroDocumento: String,
    telefono: String,
    correo: String,
    direccion: String
) : Persona(
    nombre, apellido, tipoDocumento, numeroDocumento, Rol.NO_USUARIO, telefono, correo, direccion
)