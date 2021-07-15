package co.edu.uniquindio.reciclapp.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import co.edu.uniquindio.reciclapp.model.Comprador

@Dao
interface CompradorDAO {
    @Query("SELECT * FROM Comprador")
    suspend fun obtenerTodas(): List<Comprador>

    @Query("SELECT * FROM Comprador WHERE id = :id")
    suspend fun obtenerPorId(id: Int): Comprador?

    @Update
    suspend fun actualizar(comprador: Comprador)

    @Insert
    suspend fun insertar(compradores: List<Comprador>)

    @Delete
    suspend fun eliminar(comprador: Comprador)
}