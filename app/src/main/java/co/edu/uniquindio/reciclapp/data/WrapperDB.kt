package co.edu.uniquindio.reciclapp.data

import android.content.Context
import co.edu.uniquindio.reciclapp.data.local.databases.LocalDB
import co.edu.uniquindio.reciclapp.data.remote.FirebaseDB
import co.edu.uniquindio.reciclapp.model.*
import kotlinx.coroutines.ExperimentalCoroutinesApi

class WrapperDB(val context: Context) {
    @ExperimentalCoroutinesApi
    companion object {
        // Local Wrapper
        suspend fun obtenerPorId(db: LocalDB, coleccion: String, id: Long): ObjetoBase? {
            return when (coleccion) {
                "administradores" -> {
                    val dao = db.administradorDAO()
                    dao.obtenerPorId(id)
                }
                "citas" -> {
                    val dao = db.citaDAO()
                    dao.obtenerPorId(id)
                }
                "compradores" -> {
                    val dao = db.compradorDAO()
                    dao.obtenerPorId(id)
                }
                "materiales" -> {
                    val dao = db.materialDAO()
                    dao.obtenerPorId(id)
                }
                "recolectores" -> {
                    val dao = db.recolectorDAO()
                    dao.obtenerPorId(id)
                }
                "usuarios" -> {
                    val dao = db.usuarioDAO()
                    dao.obtenerPorId(id)
                }
                "ventas" -> {
                    val dao = db.ventaDAO()
                    dao.obtenerPorId(id)
                }
                else -> {
                    null
                }
            }
        }

        suspend fun insertarLocal(db: LocalDB, obj: ObjetoBase) {
            when (obj.coleccion) {
                "administradores" -> {
                    obj as Administrador
                    val dao = db.administradorDAO()
                    dao.insertar(listOf(obj))
                }
                "citas" -> {
                    obj as Cita
                    val dao = db.citaDAO()
                    dao.insertar(listOf(obj))
                }
                "compradores" -> {
                    obj as Comprador
                    val dao = db.compradorDAO()
                    dao.insertar(listOf(obj))
                }
                "materiales" -> {
                    obj as Material
                    val dao = db.materialDAO()
                    dao.insertar(listOf(obj))
                }
                "recolectores" -> {
                    obj as Recolector
                    val dao = db.recolectorDAO()
                    dao.insertar(listOf(obj))
                }
                "usuarios" -> {
                    obj as Usuario
                    val dao = db.usuarioDAO()
                    dao.insertar(listOf(obj))
                }
                "ventas" -> {
                    obj as Venta
                    val dao = db.ventaDAO()
                    dao.insertar(listOf(obj))
                }
            }
        }

        // Global Wrapper
        suspend fun insertar(db: LocalDB, objs: List<ObjetoBase>) {
            for (obj in objs) {
                val tipo: Class<*> = obtenerJavaClass(obj)
                val localObj = obtenerPorId(db, obj.coleccion, obj.id)
                if (localObj == null) {
                    val remoteObj = FirebaseDB.obtenerPorId(obj, tipo)
                    if (remoteObj == null) {
                        insertarLocal(db, obj)
                        FirebaseDB.insertar(obj)
                    }
                }
            }
        }

        // Misc
        fun obtenerJavaClass(obj: ObjetoBase): Class<*> {
            return when (obj.coleccion) {
                "administradores" -> Administrador::class.java
                "citas" -> Cita::class.java
                "compradores" -> Comprador::class.java
                "materiales" -> Material::class.java
                "recolectores" -> Recolector::class.java
                "usuarios" -> Usuario::class.java
                "ventas" -> Venta::class.java
                else -> ObjetoBase::class.java
            }
        }
    }
}