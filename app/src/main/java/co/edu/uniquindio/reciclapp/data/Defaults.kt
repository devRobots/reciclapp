package co.edu.uniquindio.reciclapp.data

import co.edu.uniquindio.reciclapp.data.database.AdminDB
import co.edu.uniquindio.reciclapp.model.Comprador
import co.edu.uniquindio.reciclapp.model.Recolector

class Defaults(val adminDB: AdminDB) {
    init {
        initRecolectores()
        initCompradores()
    }

    fun initRecolectores() {
        val recolector1 = Recolector(1, "", 312341251, "")
        val recolector2 = Recolector(1, "", 312341251, "")
        val recolector3 = Recolector(1, "", 312341251, "")

        adminDB.recolectorDAO().insertar(listOf(recolector1, recolector2, recolector3))
    }

    fun initCompradores() {
        val comprador1 = Comprador(1, "", "", 312341251, "")

        adminDB.compradorDAO().insertar(listOf(comprador1))
    }
}