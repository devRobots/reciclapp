package co.edu.uniquindio.reciclapp.data

import android.app.Activity
import android.content.Context
import co.edu.uniquindio.reciclapp.data.database.AdminDB
import co.edu.uniquindio.reciclapp.model.*
import java.util.*

class Defaults(private val context: Activity, private val roomApp: RoomApp) {
    suspend fun init() {
        initAdministrador()
        initUsuario()
        initRecolectores()
        initCompradores()
        initCita()
        initVenta()
        initConfig()

        databaseReady()
    }

    private fun databaseReady() {
        val preferences = context.getPreferences(Context.MODE_PRIVATE)
        with(preferences.edit()) {
            putBoolean("db_ready", true)
            commit()
        }
    }

    private suspend fun initVenta() {
        val admin = roomApp.admin.administradorDAO().obtenerPorId(1)!!

        val comprador1 = roomApp.admin.compradorDAO().obtenerPorId(1)
        val comprador2 = roomApp.admin.compradorDAO().obtenerPorId(2)

        val venta1 = Venta(1, Date(), "3:21", 5, 130044, comprador1, admin)
        val venta2 = Venta(2, Date(), "4:21", 5, 1345544, comprador2, admin)

        roomApp.admin.ventaDAO().insertar(listOf(venta1, venta2))
    }

    private suspend fun initCita() {
        val usuario = roomApp.admin.usuarioDAO().obtenerPorId(1)!!

        val rec1 = roomApp.admin.recolectorDAO().obtenerPorId(1)
        val rec2 = roomApp.admin.recolectorDAO().obtenerPorId(2)
        val rec3 = roomApp.admin.recolectorDAO().obtenerPorId(3)

        val cita1 = Cita(1, Date(), "3:39", EstadoCita.ACEPTADO, 1.2, rec1, usuario)
        val cita2 = Cita(2, Date(), "4:39", EstadoCita.APLAZADO, 4.2, rec2, usuario)
        val cita3 = Cita(3, Date(), "5:39", EstadoCita.CANCELADO, 2.2, rec3, usuario)
        val cita4 = Cita(4, Date(), "6:39", EstadoCita.COMPLETADO, 4.2, rec1, usuario)
        val cita5 = Cita(5, Date(), "7:39", EstadoCita.EN_PROCESO, 3.4, rec2, usuario)

        roomApp.admin.citaDAO().insertar(listOf(cita1, cita2, cita3, cita4, cita5))
    }

    private suspend fun initUsuario() {
        val usuario1 = Usuario(
            1,
            2345,
            "Camilosky",
            "Osky",
            31223453,
            "Cr21B #24A-62",
            "camilosky@gmail.com",
            "root"
        )

        roomApp.admin.usuarioDAO().insertar(listOf(usuario1))
        roomApp.usuario.usuarioDAO().insertar(listOf(usuario1))
    }

    private suspend fun initAdministrador() {
        val administrador1 = Administrador(
            1,
            1234,
            "Camilo Q",
            "Laurente",
            31234953,
            "Cr27B #21A-72",
            "claurente@gmail.com",
            "12345"
        )

        roomApp.admin.administradorDAO().insertar(listOf(administrador1))
    }

    private suspend fun initRecolectores() {
        val recolector1 = Recolector(1, "Camilo Quiceno", 3196681290, "ccquicenol@uqvirtual.edu.co")
        val recolector2 = Recolector(2, "Samara Rincon", 3392039, "ssrinconm@uqvirtual.edu.co")
        val recolector3 = Recolector(3, "Yesid Rosas", 31392193, "ysrosast@uqvirtual.edu.co")

        roomApp.admin.recolectorDAO().insertar(listOf(recolector1, recolector2, recolector3))
    }

    private suspend fun initCompradores() {
        val comprador1 = Comprador(
            1,
            "179537",
            "Cristian Quiceno",
            3196681280,
            "ccompraquicenol@uqvirtual.edu.co"
        )
        val comprador2 = Comprador(2, "179538", "Joshua Quiceno", 31543384895, "jjoshua@uqvirtual.edu.co")

        roomApp.admin.compradorDAO().insertar(listOf(comprador1, comprador2))
    }

    private suspend fun initConfig() {
        roomApp.config.configDAO().insertar(listOf(Config(1, null, null)))
    }

}