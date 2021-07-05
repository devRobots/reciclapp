package co.edu.uniquindio.reciclapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import co.edu.uniquindio.reciclapp.data.Config
import co.edu.uniquindio.reciclapp.data.Converters
import co.edu.uniquindio.reciclapp.data.dao.ConfigDAO

@Database(
    entities = [Config::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class ConfigDB : RoomDatabase() {
    abstract fun configDAO(): ConfigDAO
}