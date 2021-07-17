package co.edu.uniquindio.reciclapp.data.local.dao

import androidx.room.*
import co.edu.uniquindio.reciclapp.model.Comprador
import co.edu.uniquindio.reciclapp.model.VentaComprador

@Dao
interface CompradorDAO {
    @Query("SELECT * FROM Comprador")
    suspend fun obtenerTodas(): List<Comprador>

    @Transaction
    @Query("SELECT * FROM Comprador")
    fun obtenerVentas(): List<VentaComprador>

    @Query("SELECT * FROM Comprador WHERE id = :id")
    suspend fun obtenerPorId(id: kotlin.Long): Comprador?

    @Update
    suspend fun actualizar(comprador: Comprador)

    @Insert
    suspend fun insertar(compradores: List<Comprador>)

    @Delete
    suspend fun eliminar(comprador: Comprador)
}