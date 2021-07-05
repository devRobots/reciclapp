package co.edu.uniquindio.reciclapp.data.dao

import androidx.room.*
import co.edu.uniquindio.reciclapp.model.Usuario

@Dao
interface UsuarioDAO {
    @Query("SELECT * FROM Usuario")
    suspend fun obtenerTodas(): List<Usuario>

    @Query("SELECT * FROM Usuario WHERE id = :id")
    suspend fun obtenerPorId(id: Int): Usuario

    @Update
    suspend fun actualizar(usuario: Usuario)

    @Insert
    suspend fun insertar(usuario: List<Usuario>)

    @Delete
    suspend fun eliminar(usuario: Usuario)
}