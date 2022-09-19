package com.example.assessment2.datebase_helper

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.assessment2.models.Exclusion
import com.example.assessment2.models.Facility
import java.util.ArrayList


class DatabaseHelper(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        val CREATE_TABLE = ("CREATE TABLE "
                + TABLE_DATA + "(" + COLUMN_ID
                + " TEXT PRIMARY KEY,"
                + COLUMN_NAME + " TEXT" + ")")
        db.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DATA)
        onCreate(db)
    }

    fun listData(): ArrayList<Facility> {
        val sql = "select * from " + TABLE_DATA
        val db = this.readableDatabase
        val data = ArrayList<Facility>()
        val cursor = db.rawQuery(sql, null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getString(0)
                val display = cursor.getString(1)
                data.add(Facility(id, display))
            } while (cursor.moveToNext())
        }
        cursor.close()
        return data
    }

    fun addFacility(data: Facility) {
        val values = ContentValues()
        values.put(COLUMN_NAME, data.name)
        values.put(COLUMN_ID, data.facilityId)
        val db = this.writableDatabase
        db.insert(TABLE_DATA, null, values)
    }

    fun addExclusion(data: Exclusion) {
        val values = ContentValues()
        values.put(COLUMN_NAME, data.optionsId)
        values.put(COLUMN_ID, data.facilityId)
        val db = this.writableDatabase
        db.insert(TABLE_DATA, null, values)
    }

    fun listDataForExclusion(): ArrayList<Facility> {
        val sql = "select * from " + TABLE_DATA
        val db = this.readableDatabase
        val data = ArrayList<Facility>()
        val cursor = db.rawQuery(sql, null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getString(0)
                val facilityId = cursor.getString(1)
                //data.add(new Exclusion(id, facilityId));
            } while (cursor.moveToNext())
        }
        cursor.close()
        return data
    }

    companion object {
        private const val DATABASE_VERSION = 5
        private const val DATABASE_NAME = "data_name"
        private const val TABLE_DATA = "data"
        private const val COLUMN_ID = "_id"
        private const val COLUMN_NAME = "facility"
    }
}