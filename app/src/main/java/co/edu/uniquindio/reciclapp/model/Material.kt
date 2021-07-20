package co.edu.uniquindio.reciclapp.model

data class Material(
    var tipo: TipoMaterial,
    var cantidad: Int,
    var unidad: TipoUnidad,
    var uidCita: String?,
    var uidVenta: String?
)