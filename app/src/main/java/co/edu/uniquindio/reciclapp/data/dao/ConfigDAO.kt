package co.edu.uniquindio.reciclapp.data.dao

import androidx.room.*
import co.edu.uniquindio.reciclapp.data.Config

@Dao
interface ConfigDAO {
    @Query("SELECT * FROM Config WHERE id = 1")
    fun obtenerConfiguraciones(): List<Config>

    @Update
    fun actualizar(config: Config)

    @Insert
    fun insertar(config: List<Config>)

    @Delete
    fun eliminar(config: Config)
}