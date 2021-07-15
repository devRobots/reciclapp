package co.edu.uniquindio.reciclapp.data.local.databases

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import co.edu.uniquindio.reciclapp.data.local.Config
import co.edu.uniquindio.reciclapp.data.local.Converters
import co.edu.uniquindio.reciclapp.data.local.dao.ConfigDAO

@Database(
    entities = [Config::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class ConfigDB : RoomDatabase() {
    abstract fun configDAO(): ConfigDAO
}