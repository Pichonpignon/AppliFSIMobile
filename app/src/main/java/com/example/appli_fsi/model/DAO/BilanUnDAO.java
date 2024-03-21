package com.example.appli_fsi.model.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.appli_fsi.model.BO.BilanUn;

import java.util.ArrayList;
import java.util.Date;

public class BilanUnDAO {
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;

    public BilanUnDAO(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public BilanUn insertBilanUn(BilanUn bilanUn){
        ContentValues values = new ContentValues();
        values.put("noteEts", bilanUn.getNoteEts());
        values.put("dateBilanUn", bilanUn.getDateBilanUn().getTime());
        values.put("noteDossierUn", bilanUn.getNoteDossierUn());
        values.put("noteOralUn", bilanUn.getNoteOralUn());
        values.put("rqBilanUn", bilanUn.getRqBilanUn());

        long id = database.insert(MySQLiteHelper.TABLE_BILAN_UN, null, values);
        bilanUn.setIdBilanUn((int) id);

        return bilanUn;
    }

    public ArrayList<BilanUn> getAllBilanUn(){
        ArrayList<BilanUn> listBilanUn = new ArrayList<>();

        Cursor cursor = database.query(true, MySQLiteHelper.TABLE_BILAN_UN,
                new String[]{"idBilanUn", "noteEts", "dateBilanUn", "noteDossierUn", "noteOralUn", "rqBilanUn"},
                null, null, null, null, null, null);

        while (cursor.moveToNext()){
            int idBilanUn = cursor.getInt(cursor.getColumnIndex("idBilanUn"));
            float noteEts = cursor.getFloat(cursor.getColumnIndex("noteEts"));
            long dateMillis = cursor.getLong(cursor.getColumnIndex("dateBilanUn"));
            Date dateBilanUn = new Date(dateMillis);
            float noteDossierUn = cursor.getFloat(cursor.getColumnIndex("noteDossierUn"));
            float noteOralUn = cursor.getFloat(cursor.getColumnIndex("noteOralUn"));
            String rqBilanUn = cursor.getString(cursor.getColumnIndex("rqBilanUn"));

            BilanUn bilanUn = new BilanUn(idBilanUn, noteEts, dateBilanUn, noteDossierUn, noteOralUn, rqBilanUn);
            listBilanUn.add(bilanUn);
        }

        cursor.close();
        return listBilanUn;
    }

    public BilanUn getBilanUnById(int id){
        BilanUn bilanUn = null;

        Cursor cursor = database.query(true, MySQLiteHelper.TABLE_BILAN_UN,
                new String[]{"idBilanUn", "noteEts", "dateBilanUn", "noteDossierUn", "noteOralUn", "rqBilanUn"},
                "idBilanUn = " + id, null, null, null, null, null);

        while (cursor.moveToNext()){
            float noteEts = cursor.getFloat(cursor.getColumnIndex("noteEts"));
            long dateMillis = cursor.getLong(cursor.getColumnIndex("dateBilanUn"));
            Date dateBilanUn = new Date(dateMillis);
            float noteDossierUn = cursor.getFloat(cursor.getColumnIndex("noteDossierUn"));
            float noteOralUn = cursor.getFloat(cursor.getColumnIndex("noteOralUn"));
            String rqBilanUn = cursor.getString(cursor.getColumnIndex("rqBilanUn"));

            bilanUn = new BilanUn(id, noteEts, dateBilanUn, noteDossierUn, noteOralUn, rqBilanUn);
        }

        cursor.close();
        return bilanUn;
    }

    public void deleteBilanUn(BilanUn bilanUn){
        int id = bilanUn.getIdBilanUn();
        database.delete(MySQLiteHelper.TABLE_BILAN_UN, "idBilanUn = " + id, null);
    }
}

