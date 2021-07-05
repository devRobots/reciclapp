package co.edu.uniquindio.reciclapp.data.dao

import androidx.room.*
import co.edu.uniquindio.reciclapp.model.Usuario

@Dao
interface UsuarioDAO {
    @Query("SELECT * FROM Usuario")
    fun obtenerTodas(): List<Usuario>

    @Query("SELECT * FROM Usuario WHERE id = :id")
    fun obtenerPorId(id: Int): Usuario

    @Update
    fun actualizar(usuario: Usuario)

    @Insert
    fun insertar(usuario: List<Usuario>)

    @Delete
    fun eliminar(usuario: Usuario)
}