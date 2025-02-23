package edu.sungshin.baseballclub

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import android.database.sqlite.SQLiteDatabase
import android.content.Context
import android.util.Log

class bbcContentProvider : ContentProvider() {
    companion object {
        const val AUTHORITY = "edu.sungshin.baseballclub.provider"
        const val FACILITIES_TABLE = "facilities"
        const val FNB_TABLE = "FnB"

        val CONTENT_URI_FACILITIES: Uri = Uri.parse("content://$AUTHORITY/$FACILITIES_TABLE")
        val CONTENT_URI_FNB: Uri = Uri.parse("content://$AUTHORITY/$FNB_TABLE")

        private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH).apply {
            addURI(AUTHORITY, FACILITIES_TABLE, 1)
            addURI(AUTHORITY, FNB_TABLE, 2)
        }
    }

    private lateinit var database: SQLiteDatabase

    override fun onCreate(): Boolean {
        // 데이터베이스 경로 명시적으로 설정
        val context: Context = context!!
        val databasePath = "/data/data/${context.packageName}/databases/bbc"
        Log.d("BBCContentProvider", "Database Path: $databasePath")

        // 데이터베이스 열기
        database = context.openOrCreateDatabase(databasePath, Context.MODE_PRIVATE, null)

        // 테이블 확인 (디버깅용)
        val cursor = database.rawQuery("SELECT name FROM sqlite_master WHERE type='table'", null)
        while (cursor.moveToNext()) {
            val tableName = cursor.getString(0)
            Log.d("BBCContentProvider", "Table: $tableName")
        }
        cursor.close()

        return true
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        return when (uriMatcher.match(uri)) {
            1 -> {
                Log.d("BBCContentProvider", "Querying facilities table")
                database.query(FACILITIES_TABLE, projection, selection, selectionArgs, null, null, sortOrder)
            }
            2 -> {
                Log.d("BBCContentProvider", "Querying FnB table")
                database.query(FNB_TABLE, projection, selection, selectionArgs, null, null, sortOrder)
            }
            else -> throw IllegalArgumentException("Unknown URI: $uri")
        }
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        throw UnsupportedOperationException("Insert not supported")
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?): Int {
        throw UnsupportedOperationException("Update not supported")
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        throw UnsupportedOperationException("Delete not supported")
    }

    override fun getType(uri: Uri): String? {
        return when (uriMatcher.match(uri)) {
            1 -> "vnd.android.cursor.dir/$FACILITIES_TABLE"
            2 -> "vnd.android.cursor.dir/$FNB_TABLE"
            else -> throw IllegalArgumentException("Unknown URI: $uri")
        }
    }
}