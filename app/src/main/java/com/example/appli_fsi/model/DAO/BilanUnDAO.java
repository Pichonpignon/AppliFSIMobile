package com.example.appli_fsi.model.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    public void open() {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        database.close();
    }

    public BilanUn insertBilanUn(BilanUn bilanUn) {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_NOTE_ETS, bilanUn.getNoteEts());
        values.put(MySQLiteHelper.COLUMN_DATE_BILAN_UN, bilanUn.getDateBilanUn().getTime());
        values.put(MySQLiteHelper.COLUMN_NOTE_DOSSIER_UN, bilanUn.getNoteDossierUn());
        values.put(MySQLiteHelper.COLUMN_NOTE_ORAL_UN, bilanUn.getNoteOralUn());
        values.put(MySQLiteHelper.COLUMN_RQ_BILAN_UN, bilanUn.getRqBilanUn());

        long id = database.insert(MySQLiteHelper.TABLE_BILAN_UN, null, values);
        bilanUn.setIdBilanUn((int) id);

        return bilanUn;
    }

    public ArrayList<BilanUn> getAllBilanUn() {
        ArrayList<BilanUn> listBilanUn = new ArrayList<>();

        String[] colonnes = {
                MySQLiteHelper.COLUMN_ID_BILAN_UN,
                MySQLiteHelper.COLUMN_NOTE_ETS,
                MySQLiteHelper.COLUMN_DATE_BILAN_UN,
                MySQLiteHelper.COLUMN_NOTE_DOSSIER_UN,
                MySQLiteHelper.COLUMN_NOTE_ORAL_UN,
                MySQLiteHelper.COLUMN_RQ_BILAN_UN
        };

        Cursor cursor = database.query(MySQLiteHelper.TABLE_BILAN_UN, colonnes, null, null, null, null, null);

        while (cursor.moveToNext()) {
            BilanUn bilanUn = getBilanUnFromCursor(cursor);
            listBilanUn.add(bilanUn);
        }

        cursor.close();
        return listBilanUn;
    }

    public BilanUn getBilanUnById(int id) {
        BilanUn bilanUn = null;

        String[] colonnes = {
                MySQLiteHelper.COLUMN_ID_BILAN_UN,
                MySQLiteHelper.COLUMN_NOTE_ETS,
                MySQLiteHelper.COLUMN_DATE_BILAN_UN,
                MySQLiteHelper.COLUMN_NOTE_DOSSIER_UN,
                MySQLiteHelper.COLUMN_NOTE_ORAL_UN,
                MySQLiteHelper.COLUMN_RQ_BILAN_UN
        };

        String selection = MySQLiteHelper.COLUMN_ID_BILAN_UN + " = ?";
        String[] selectionArgs = {String.valueOf(id)};

        Cursor cursor = database.query(MySQLiteHelper.TABLE_BILAN_UN, colonnes, selection, selectionArgs, null, null, null);

        if (cursor.moveToNext()) {
            bilanUn = getBilanUnFromCursor(cursor);
        }

        cursor.close();
        return bilanUn;
    }

    public void deleteBilanUn(BilanUn bilanUn) {
        int id = bilanUn.getIdBilanUn();
        String selection = MySQLiteHelper.COLUMN_ID_BILAN_UN + " = ?";
        String[] selectionArgs = {String.valueOf(id)};
        database.delete(MySQLiteHelper.TABLE_BILAN_UN, selection, selectionArgs);
    }

    private BilanUn getBilanUnFromCursor(Cursor cursor) {
        int idBilanUn = cursor.getInt(cursor.getColumnIndex(MySQLiteHelper.COLUMN_ID_BILAN_UN));
        float noteEts = cursor.getFloat(cursor.getColumnIndex(MySQLiteHelper.COLUMN_NOTE_ETS));
        long dateMillis = cursor.getLong(cursor.getColumnIndex(MySQLiteHelper.COLUMN_DATE_BILAN_UN));
        Date dateBilanUn = new Date(dateMillis);
        float noteDossierUn = cursor.getFloat(cursor.getColumnIndex(MySQLiteHelper.COLUMN_NOTE_DOSSIER_UN));
        float noteOralUn = cursor.getFloat(cursor.getColumnIndex(MySQLiteHelper.COLUMN_NOTE_ORAL_UN));
        String rqBilanUn = cursor.getString(cursor.getColumnIndex(MySQLiteHelper.COLUMN_RQ_BILAN_UN));

        return new BilanUn(idBilanUn, noteEts, dateBilanUn, noteDossierUn, noteOralUn, rqBilanUn);
    }
}

