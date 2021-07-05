package co.edu.uniquindio.reciclapp.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import co.edu.uniquindio.reciclapp.model.Comprador

@Dao
interface CompradorDAO {
    @Query("SELECT * FROM Comprador")
    fun obtenerTodas(): List<Comprador>

    @Query("SELECT * FROM Comprador WHERE id = :id")
    fun obtenerPorId(id: Int): Comprador

    @Update
    fun actualizar(comprador: Comprador)

    @Insert
    fun insertar(compradores: List<Comprador>)

    @Delete
    fun eliminar(comprador: Comprador)
}