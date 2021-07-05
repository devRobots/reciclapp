package co.edu.uniquindio.reciclapp.data.dao

import androidx.room.*
import co.edu.uniquindio.reciclapp.model.Administrador


@Dao
interface AdministradorDAO {
    @Query("SELECT * FROM Administrador")
    suspend fun obtenerTodas(): List<Administrador>

    @Query("SELECT * FROM Administrador WHERE id = :id")
    suspend fun obtenerPorId(id: Int): Administrador

    @Update
    suspend fun actualizar(administrador: Administrador)

    @Insert
    suspend fun insertar(administrador: List<Administrador>)

    @Delete
    suspend fun eliminar(administrador: Administrador)
}