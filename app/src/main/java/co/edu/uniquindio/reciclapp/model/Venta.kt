package co.edu.uniquindio.reciclapp.model

import java.util.*

class Venta(
    var fecha: Date,
    var hora: String,
    var precio: Long,
    var uidComprador: String?,
    var uidOperador: String?
){
    constructor() :this(Date(),"",0,null,null)
}