package fr.utt.if26.todoist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Alexandre on 21/01/2018.
 */

public class ModulePersistance extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Todo.db"; // nom du fichier pour la base
    private static final String TABLE_MODULES = "todo"; // nom de la table
    private static final String ATTRIBUT_ID = "id"; // liste des attributs
    private static final String ATTRIBUT_NOM = "nom"; // liste des attributs
    private static final String ATTRIBUT_DETAIL = "detail";
    private static final Date ATTRIBUT_DATE = new Date();

    public ModulePersistance(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String table_module_create = "CREATE TABLE " + TABLE_MODULES +
                "(" + ATTRIBUT_ID + " INTEGER primary_key, " +
                ATTRIBUT_NOM + " TEXT, " +
                ATTRIBUT_DETAIL + " TEXT, " +
                ATTRIBUT_DATE + " DATE)";
        db.execSQL(table_module_create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MODULES);
        onCreate(db);
    }

    public void addElement(ToDo toDo) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(ATTRIBUT_NOM, toDo.getNom());
        values.put(ATTRIBUT_DETAIL, toDo.getDetail());
        //values.put(ATTRIBUT_DATE, toDo.getDate());
        db.insert(TABLE_MODULES, null, values);
    }

    public ArrayList<ToDo> getAllElements() {
        ArrayList<ToDo> modulesList = new ArrayList<ToDo>();
        String selectQuery = "SELECT  * FROM " + TABLE_MODULES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ToDo m = new ToDo(cursor.getString(0), cursor.getString(1), new Date());
                modulesList.add(m);
            } while (cursor.moveToNext());
        }
        return modulesList;
    }

}
