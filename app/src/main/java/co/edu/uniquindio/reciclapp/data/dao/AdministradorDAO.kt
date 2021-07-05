package co.edu.uniquindio.reciclapp.data.dao

import androidx.room.*
import co.edu.uniquindio.reciclapp.model.Administrador


@Dao
interface AdministradorDAO {
    @Query("SELECT * FROM Administrador")
    fun obtenerTodas(): List<Administrador>

    @Query("SELECT * FROM Administrador WHERE id = :id")
    fun obtenerPorId(id: Int): Administrador

    @Update
    fun actualizar(administrador: Administrador)

    @Insert
    fun insertar(administrador: List<Administrador>)

    @Delete
    fun eliminar(administrador: Administrador)
}