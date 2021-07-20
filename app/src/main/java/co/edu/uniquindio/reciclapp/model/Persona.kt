package co.edu.uniquindio.reciclapp.model

open class Persona(
    var nombre: String,
    var apellido: String?,
    var tipoDocumento: TipoDocumento,
    var numeroDocumento: String,
    val rol: Rol,
    var telefono: String?,
    var correo: String,
    var direccion: String?
) {
    companion object {
        fun fromString(personaCsv: String): Persona? {
            val personaValues = personaCsv.split(",")
            return if (personaValues.size == 8) {
                val nombre = personaValues[0]
                val apellido = personaValues[1]
                val tipoDocumento = TipoDocumento.valueOf(personaValues[2].uppercase())
                val numeroDocumento = personaValues[3]
                val rol = Rol.valueOf(personaValues[4].uppercase())
                val telefono = personaValues[5]
                val correo = personaValues[6]
                val direccion = personaValues[7]

                val p = Persona(
                    nombre, apellido, tipoDocumento, numeroDocumento,
                    rol, telefono, correo, direccion
                )

                when (rol) {
                    Rol.OPERADOR -> p as Operador
                    Rol.CIUDADANO -> p as Ciudadano
                    else -> p
                }
            } else {
                null
            }
        }
    }

    override fun toString(): String {
        var output = ""

        output += "$nombre,"
        output += "${if (apellido != null) apellido else ""},"
        output += "$tipoDocumento,$numeroDocumento,"
        output += "$rol,"
        output += "${if (telefono != null) telefono else ""},"
        output += "$correo,"
        output += "${if (direccion != null) direccion else ""}"

        return output
    }

    fun obtenerNombreCompleto(): String {
        val nombre = nombre
        val apellido = if (apellido != null) apellido else ""
        return "$nombre $apellido"
    }
}
