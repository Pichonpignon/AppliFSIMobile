package com.example.appli_fsi.model.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        database.close();
    }

    public BilanDeux insertBilan(BilanDeux bilanDeux) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_NOTE_ORAL_DEUX, bilanDeux.getNoteOralDeux());
        values.put(MySQLiteHelper.COLUMN_NOTE_DOSSIER_DEUX, bilanDeux.getNoteDossierDeux());
        values.put(MySQLiteHelper.COLUMN_DATE_BILAN_DEUX, bilanDeux.getDateBilanDeux().getTime());
        values.put(MySQLiteHelper.COLUMN_RQ_BILAN_DEUX, bilanDeux.getRqBilanDeux());
        values.put(MySQLiteHelper.COLUMN_SUJET_MEMOIRE, bilanDeux.getSujetMemoire());

        long id = database.insert(MySQLiteHelper.TABLE_BILAN_DEUX, null, values);
        bilanDeux.setIdBilanDeux((int) id);

        return bilanDeux;
    }

    public ArrayList<BilanDeux> getAllBilanDeux() {
        ArrayList<BilanDeux> listBilans = new ArrayList<>();

        String[] colonnes = {
                MySQLiteHelper.COLUMN_ID_BILAN_DEUX,
                MySQLiteHelper.COLUMN_NOTE_ORAL_DEUX,
                MySQLiteHelper.COLUMN_NOTE_DOSSIER_DEUX,
                MySQLiteHelper.COLUMN_DATE_BILAN_DEUX,
                MySQLiteHelper.COLUMN_RQ_BILAN_DEUX,
                MySQLiteHelper.COLUMN_SUJET_MEMOIRE
        };

        Cursor cursor = database.query(MySQLiteHelper.TABLE_BILAN_DEUX, colonnes, null, null, null, null, null);

        while (cursor.moveToNext()) {
            BilanDeux bilanDeux = getBilanDeuxFromCursor(cursor);
            listBilans.add(bilanDeux);
        }

        cursor.close();
        return listBilans;
    }

    public BilanDeux getBilanById(int id) {
        BilanDeux bilanDeux = null;

        String[] colonnes = {
                MySQLiteHelper.COLUMN_ID_BILAN_DEUX,
                MySQLiteHelper.COLUMN_NOTE_ORAL_DEUX,
                MySQLiteHelper.COLUMN_NOTE_DOSSIER_DEUX,
                MySQLiteHelper.COLUMN_DATE_BILAN_DEUX,
                MySQLiteHelper.COLUMN_RQ_BILAN_DEUX,
                MySQLiteHelper.COLUMN_SUJET_MEMOIRE
        };

        String selection = MySQLiteHelper.COLUMN_ID_BILAN_DEUX + " = ?";
        String[] selectionArgs = {String.valueOf(id)};

        Cursor cursor = database.query(MySQLiteHelper.TABLE_BILAN_DEUX, colonnes, selection, selectionArgs, null, null, null);

        if (cursor.moveToNext()) {
            bilanDeux = getBilanDeuxFromCursor(cursor);
        }

        cursor.close();
        return bilanDeux;
    }

    public void deleteBilan(BilanDeux bilanDeux) {
        int id = bilanDeux.getIdBilanDeux();
        String selection = MySQLiteHelper.COLUMN_ID_BILAN_DEUX + " = ?";
        String[] selectionArgs = {String.valueOf(id)};
        database.delete(MySQLiteHelper.TABLE_BILAN_DEUX, selection, selectionArgs);
    }

    private BilanDeux getBilanDeuxFromCursor(Cursor cursor) {
        int idBilanDeux = cursor.getInt(cursor.getColumnIndex(MySQLiteHelper.COLUMN_ID_BILAN_DEUX));
        float noteOralDeux = cursor.getFloat(cursor.getColumnIndex(MySQLiteHelper.COLUMN_NOTE_ORAL_DEUX));
        float noteDossierDeux = cursor.getFloat(cursor.getColumnIndex(MySQLiteHelper.COLUMN_NOTE_DOSSIER_DEUX));
        long dateMillis = cursor.getLong(cursor.getColumnIndex(MySQLiteHelper.COLUMN_DATE_BILAN_DEUX));
        Date dateBilanDeux = new Date(dateMillis);
        String rqBilanDeux = cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_RQ_BILAN_DEUX));
        String sujetMemoire = cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_SUJET_MEMOIRE));

        return new BilanDeux(idBilanDeux, noteOralDeux, noteDossierDeux, dateBilanDeux, rqBilanDeux, sujetMemoire);
    }
}
