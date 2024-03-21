package com.example.appli_fsi.model.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.appli_fsi.model.BO.BilanDeux;

import java.util.ArrayList;
import java.util.Date;

public class BilanDeuxDAO {
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;

    public BilanDeuxDAO(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public BilanDeux insertBilan(BilanDeux bilanDeux){
        ContentValues values = new ContentValues();
        values.put("noteOralDeux", bilanDeux.getNoteOralDeux());
        values.put("noteDossierDeux", bilanDeux.getNoteDossierDeux());


        long id = database.insert(MySQLiteHelper.TABLE_BILAN_DEUX, null, values);
        bilanDeux.setIdBilanDeux((int) id);

        return bilanDeux;
    }

    public ArrayList<BilanDeux> getAllBilanDeux(){
        ArrayList<BilanDeux> listBilans = new ArrayList<>();

        Cursor cursor = database.query(true, MySQLiteHelper.TABLE_BILAN_DEUX,
                new String[]{"idBilanDeux", "noteOralDeux", "noteDossierDeux", "dateBilanDeux", "rqBilanDeux", "sujetMemoire"},
                null, null, null, null, null, null);

        while (cursor.moveToNext()){
            int idBilanDeux = cursor.getInt(cursor.getColumnIndex("idBilanDeux"));
            float noteOralDeux = cursor.getFloat(cursor.getColumnIndex("noteOralDeux"));
            float noteDossierDeux = cursor.getFloat(cursor.getColumnIndex("noteDossierDeux"));
            long dateMillis = cursor.getLong(cursor.getColumnIndex("dateBilanDeux"));
            Date dateBilanDeux = new Date(dateMillis);
            String rqBilanDeux = cursor.getString(cursor.getColumnIndex("rqBilanDeux"));
            String sujetMemoire = cursor.getString(cursor.getColumnIndex("sujetMemoire"));

            BilanDeux bilanDeux = new BilanDeux(idBilanDeux, noteOralDeux, noteDossierDeux, dateBilanDeux, rqBilanDeux, sujetMemoire);
            listBilans.add(bilanDeux);
        }

        cursor.close();
        return listBilans;
    }


    public BilanDeux getBilanById(int id){
        BilanDeux bilanDeux = null;

        Cursor cursor = database.query(true, MySQLiteHelper.TABLE_BILAN_DEUX,
                new String[]{"idBilanDeux", "noteOralDeux", "noteDossierDeux", "dateBilanDeux", "rqBilanDeux", "sujetMemoire"},
                "idBilanDeux = " + id, null, null, null, null, null);

        while (cursor.moveToNext()){
            float noteOralDeux = cursor.getFloat(cursor.getColumnIndex("noteOralDeux"));
            float noteDossierDeux = cursor.getFloat(cursor.getColumnIndex("noteDossierDeux"));
            long dateMillis = cursor.getLong(cursor.getColumnIndex("dateBilanDeux"));
            Date dateBilanDeux = new Date(dateMillis);
            String rqBilanDeux = cursor.getString(cursor.getColumnIndex("rqBilanDeux"));
            String sujetMemoire = cursor.getString(cursor.getColumnIndex("sujetMemoire"));

            bilanDeux = new BilanDeux(id, noteOralDeux, noteDossierDeux, dateBilanDeux, rqBilanDeux, sujetMemoire);
        }

        cursor.close();
        return bilanDeux;
    }

    public void deleteBilan(BilanDeux bilanDeux){
        int id = bilanDeux.getIdBilanDeux();
        database.delete(MySQLiteHelper.TABLE_BILAN_DEUX, "idBilanDeux = " + id, null);
    }
}

