package co.edu.uniquindio.reciclapp.data.local.dao

import androidx.room.*
import co.edu.uniquindio.reciclapp.data.local.Config

@Dao
interface ConfigDAO {
    @Query("SELECT * FROM Config WHERE id = 1")
    suspend fun obtenerConfiguraciones(): Config

    @Update
    suspend fun actualizar(config: Config)

    @Insert
    suspend fun insertar(config: List<Config>)

    @Delete
    suspend fun eliminar(config: Config)
}