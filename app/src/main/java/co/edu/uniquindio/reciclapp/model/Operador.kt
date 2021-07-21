package co.edu.uniquindio.reciclapp.model

class Operador(
    nombre: String,
    apellido: String?,
    tipoDocumento: TipoDocumento,
    numeroDocumento: String,
    telefono: String,
    correo: String,
    direccion: String
) : Persona (
    nombre, apellido, tipoDocumento, numeroDocumento, Rol.OPERADOR, telefono, correo, direccion
)