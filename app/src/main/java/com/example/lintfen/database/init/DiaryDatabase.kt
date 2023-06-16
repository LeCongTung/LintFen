package com.example.lintfen.database.init

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lintfen.database.daos.DiaryDao

//@Database(entities = [SaveMoney::class], version = 1)
//abstract class ImageDatabase: RoomDatabase() {
//
//    abstract fun diariesDao(): DiaryDao
//
//    companion object{
//        @Volatile
//        private var INSTANCE: ImageDatabase?= null
//        private const val DB_NAME = "diary_database"
//
//        fun getDatabase(context: Context): ImageDatabase {
//            val tempInstance = INSTANCE
//            if (tempInstance != null) {
//                return tempInstance
//            }
//            synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    ImageDatabase::class.java,
//                    DB_NAME
//                ).allowMainThreadQueries().build()
//                INSTANCE = instance
//                return instance
//            }
//        }
//    }
//}