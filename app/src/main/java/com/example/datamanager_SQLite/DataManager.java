package com.example.datamanager_SQLite;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.beans_SQLite.Client;

import java.util.ArrayList;
import java.util.List;



/**
 * Wraps the logic for a SQLite database
 */
public class DataManager extends SQLiteOpenHelper {

    // Database Information
    private static final String DB_NAME = "Users.db";

    // Database version
    private static final int DB_VERSION = 1;

    // Table Name
    public static final String TABLE_NAME = "Client";

    // Table columns
    private static final String ID = "id";
    private static final String NAME = "LoginUser";
    private static final String PASS = "Pass";


    // Creating table query
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" +
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAME + " TEXT NOT NULL, " +
            PASS + " TEXT NOT NULL " +
            ");";

    private final Context context;

    public DataManager(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int oldVersion, int newVersion) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sQLiteDatabase);
    }

    //------------------------------ selectAll ------------------------------//

    public List<Client> selectAllClients() {
        List<Client> ret = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase sQLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sQLiteDatabase.rawQuery(query, null);
        Client client;
        while (cursor.moveToNext()) {
            client = new Client();
            client.setId(cursor.getInt(0));
            client.setLoginUser(cursor.getString(1));
            client.setPass(cursor.getString(2));

            ret.add( client );
        }
        cursor.close();
        sQLiteDatabase.close();
        return ret;
    }

    //------------------------------ Select by Id ------------------------------//

    public Client selectById (int id) {
        String query = "Select * FROM " + TABLE_NAME + " WHERE " + ID +
                " = " + "'" + id + "'";
        SQLiteDatabase sQLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sQLiteDatabase.rawQuery(query, null);

        Client client = new Client ();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            client.setId(cursor.getInt(0));
            client.setLoginUser(cursor.getString(1));
            client.setPass(cursor.getString(2));

            cursor.close();
        } else {
            client = null;
        }
        sQLiteDatabase.close();
        return client;
    }

    //-----------------------------Select Ultimo-------------------------------//

    public Client selectUltimo () {
        String query = "Select * FROM " + TABLE_NAME + " ORDER BY " + ID +" DESC  ";
        SQLiteDatabase sQLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sQLiteDatabase.rawQuery(query, null);

        Client client = new Client ();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            client.setId(cursor.getInt(0));
            client.setLoginUser(cursor.getString(1));
            client.setPass(cursor.getString(2));

            cursor.close();
        } else {
            client = null;
        }
        sQLiteDatabase.close();
        return client;
    }

    //----------------------------- Insert ------------------------------//

    public void insert (Client client) {
        ContentValues values = new ContentValues();
        values.put( NAME, client.getLoginUser());
        values.put( PASS, client.getPass());


        SQLiteDatabase sQLiteDatabase = this.getWritableDatabase();
        sQLiteDatabase.insert(TABLE_NAME, null, values);
        // sQLiteDatabase.close();
    }

    //------------------------------ Update ------------------------------//

    public boolean update (Client client) {
        SQLiteDatabase sQLiteDatabase = this.getWritableDatabase();
        ContentValues args = new ContentValues();
        args.put( ID, client.getId());
        args.put( NAME, client.getLoginUser());
        args.put( PASS, client.getPass());

        String whereClause = ID + "=" + client.getId();
        return sQLiteDatabase.update(TABLE_NAME, args, whereClause, null) > 0;
    }

    //------------------------------ Delete ------------------------------//

    public int deleteById (int id) {
        int ret;
        SQLiteDatabase sQLiteDatabase = this.getWritableDatabase();
        Client client = new Client ();
        client.setId(id);
        ret = sQLiteDatabase.delete(TABLE_NAME, ID + "=?",
                new String[] {
                        String.valueOf(client.getId())
                });
        sQLiteDatabase.close();
        return ret;
    }

    //------------------------------ ifExist / ifEmpty ------------------------------//

    public boolean ifTableExists() {
        boolean ret = false;
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.getReadableDatabase();
            String query = "select DISTINCT tbl_name from sqlite_master where tbl_name = '" +
                    TABLE_NAME + "'";
            cursor = sQLiteDatabase.rawQuery( query, null );
            if (cursor != null) {
                if (cursor.getCount() > 0) {
                    ret = true;
                }
            }
        } catch (Exception e) {
            // Nothing to do here...
        } finally{
            try{
                assert cursor != null;
                cursor.close();
            } catch (NullPointerException e) {
                // Nothing to do here...
            }
        }
        return ret;
    }

    public boolean isEmpty(){
        boolean ret = true;
        Cursor cursor = null;
        try {
            SQLiteDatabase sQLiteDatabase = this.getReadableDatabase();
            cursor = sQLiteDatabase.rawQuery( "SELECT count(*) FROM (select 0 from " +
                    TABLE_NAME + " limit 1)", null );
            cursor.moveToFirst();
            int count = cursor.getInt( 0 );
            if (count > 0) {
                ret = false;
            }
        } catch (Exception e) {
            // Nothing to do here...
        }
        finally {
            try {
                assert cursor != null;
                cursor.close();
            } catch (Exception e) {
                // Nothing to do here...
            }
        }
        return ret;
    }
}