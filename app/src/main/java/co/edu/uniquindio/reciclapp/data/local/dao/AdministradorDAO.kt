package co.edu.uniquindio.reciclapp.data.local.dao

import androidx.room.*
import co.edu.uniquindio.reciclapp.model.Administrador
import co.edu.uniquindio.reciclapp.model.Usuario


@Dao
interface AdministradorDAO {
    @Query("SELECT * FROM Administrador")
    suspend fun obtenerTodas(): List<Administrador>

    @Query("SELECT * FROM Administrador WHERE id = :id")
    suspend fun obtenerPorId(id: Int): Administrador?

    @Query("SELECT * FROM Administrador WHERE cedula = :cedula AND contrasenia = :contrasenia")
    suspend fun login(cedula: Int, contrasenia: String): Administrador?

    @Update
    suspend fun actualizar(administrador: Administrador)

    @Insert
    suspend fun insertar(administrador: List<Administrador>)

    @Delete
    suspend fun eliminar(administrador: Administrador)
}