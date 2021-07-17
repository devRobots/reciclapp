package co.edu.uniquindio.reciclapp.data.local.dao

import androidx.room.*
import co.edu.uniquindio.reciclapp.model.CitaUsuario
import co.edu.uniquindio.reciclapp.model.Usuario

@Dao
interface UsuarioDAO {
    @Query("SELECT * FROM Usuario")
    suspend fun obtenerTodas(): List<Usuario>

    @Transaction
    @Query("SELECT * FROM Usuario")
    suspend fun obtenerCitas(): List<CitaUsuario>

    @Query("SELECT * FROM Usuario WHERE id = :id")
    suspend fun obtenerPorId(id: kotlin.Long): Usuario?

    @Query("SELECT * FROM Usuario WHERE cedula = :cedula AND contrasenia = :contrasenia")
    suspend fun login(cedula: Int, contrasenia: String): Usuario?

    @Update
    suspend fun actualizar(usuario: Usuario)

    @Insert
    suspend fun insertar(usuario: List<Usuario>)

    @Delete
    suspend fun eliminar(usuario: Usuario)
}