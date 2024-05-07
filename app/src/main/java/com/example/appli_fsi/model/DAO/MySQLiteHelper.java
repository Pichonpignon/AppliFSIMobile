package com.example.appli_fsi.model.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_ETUDIANT = "Etudiant";
    public static final String TABLE_BILAN_UN = "BilanUn";
    public static final String TABLE_BILAN_DEUX = "BilanDeux";

    // Colonnes de la table Etudiant
    public static final String COLUMN_ID_ETU = "numEtu";
    public static final String COLUMN_NOM_ETU = "nomEtu";
    public static final String COLUMN_PRE_ETU = "preEtu";
    public static final String COLUMN_TEL_ETU = "telEtu";
    public static final String COLUMN_MAIL_ETU = "mailEtu";
    public static final String COLUMN_ETS_ETU = "etsEtu";
    public static final String COLUMN_TUT_ETS_ETU = "tutEtsEtu";
    public static final String COLUMN_TUT_ECO = "tutEco";
    public static final String COLUMN_MDP_ETU = "mdpEtu";
    public static final String COLUMN_LOGIN_ETU = "loginEtu";

    // Colonnes de la table BilanUn
    public static final String COLUMN_ID_BILAN_UN = "idBilanUn";
    public static final String COLUMN_NOTE_ETS = "noteEts";
    public static final String COLUMN_NOTE_DOSSIER_UN = "noteDossierUn";
    public static final String COLUMN_NOTE_ORAL_UN = "noteOralUn";
    public static final String COLUMN_DATE_BILAN_UN = "dateBilanUn";
    public static final String COLUMN_RQ_BILAN_UN = "rqBilanUn";

    // Colonnes de la table BilanDeux
    public static final String COLUMN_ID_BILAN_DEUX = "idBilanDeux";
    public static final String COLUMN_NOTE_ORAL_DEUX = "noteOralDeux";
    public static final String COLUMN_NOTE_DOSSIER_DEUX = "noteDossierDeux";
    public static final String COLUMN_DATE_BILAN_DEUX = "dateBilanDeux";
    public static final String COLUMN_RQ_BILAN_DEUX = "rqBilanDeux";
    public static final String COLUMN_SUJET_MEMOIRE = "sujetMemoire";

    private static final String DATABASE_NAME = "applifsidatabase";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE_ETUDIANT = " CREATE TABLE IF NOT EXISTS " + TABLE_ETUDIANT +
            "(" + COLUMN_ID_ETU + " integer primary key autoincrement, " +
            COLUMN_NOM_ETU + " text, " + COLUMN_PRE_ETU + " text, " + COLUMN_TEL_ETU + " text, " + COLUMN_MAIL_ETU + " text, " + COLUMN_ETS_ETU + " text, " +
            COLUMN_TUT_ETS_ETU + " text, " + COLUMN_TUT_ECO + " text, " + COLUMN_LOGIN_ETU + " text, " + COLUMN_MDP_ETU   + " text);";

    private static final String DATABASE_CREATE_BILANUN = "CREATE TABLE IF NOT EXISTS " + TABLE_BILAN_UN +
            "(" + COLUMN_ID_BILAN_UN + " integer primary key autoincrement," +
            COLUMN_NOTE_ETS + " float, " + COLUMN_NOTE_DOSSIER_UN + " float, " + COLUMN_NOTE_ORAL_UN + " float, " + COLUMN_DATE_BILAN_UN + " date, " + COLUMN_RQ_BILAN_UN + " text);";

    private static final String DATABASE_CREATE_BILANDEUX = "CREATE TABLE IF NOT EXISTS " + TABLE_BILAN_DEUX +
            "(" + COLUMN_ID_BILAN_DEUX + " integer primary key autoincrement," +
            COLUMN_NOTE_ORAL_DEUX + " float, " + COLUMN_NOTE_DOSSIER_DEUX + " float, " + COLUMN_DATE_BILAN_DEUX + " date, " + COLUMN_RQ_BILAN_DEUX + " text, " + COLUMN_SUJET_MEMOIRE + " text);";

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
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