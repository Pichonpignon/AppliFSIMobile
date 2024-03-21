package com.example.appli_fsi.model.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_ETUDIANT = "Etudiant";
    public static final String TABLE_BILAN_UN = "BilanUn";
    public static final String TABLE_BILAN_DEUX = "BilanDeux";
    private static final String DATABASE_NAME = "applifsi.db";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_CREATE_ETUDIANT = " CREATE TABLE IF NOT EXISTS " + TABLE_ETUDIANT +
            "(numEtu  integer primary key autoincrement, " +
            " nomEtu text, preEtu text, telEtu text, mailEtu text, etsEtu text, " +
            "tutEtsEtu text, tutEco text, loginEtu text, mdpEtu text);";

    private static final String DATABASE_CREATE_BILANUN = "CREATE TABLE IF NOT EXISTS " + TABLE_BILAN_UN +
            "(idBilanUn integer primary key autoincrement," +
            "noteEts float, noteDossierUn float, noteOralUn float, dateBilanUn date, rqBilanUn text);";
    private static final String DATABASE_CREATE_BILANDEUX = "CREATE TABLE IF NOT EXISTS " + TABLE_BILAN_DEUX +
            "(idBilanDeux integer primary key autoincrement," +
            "noteOralDeux float, noteDossierDeux float, dateBilanDeux date, rqBilanDeux text, sujetMemoire text);";
    public MySQLiteHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(DATABASE_CREATE_ETUDIANT);
        db.execSQL(DATABASE_CREATE_BILANUN);
        db.execSQL(DATABASE_CREATE_BILANDEUX);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ETUDIANT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BILAN_UN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BILAN_DEUX);
        onCreate(db);
    }
}
