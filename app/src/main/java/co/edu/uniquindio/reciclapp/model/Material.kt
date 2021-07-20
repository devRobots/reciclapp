package co.edu.uniquindio.reciclapp.model

data class Material(
    var tipo: TipoMaterial,
    var cantidad: Int,
    var uidCita: String?,
    var uidVenta: String?
)