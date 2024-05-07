package com.example.appli_fsi.model.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.appli_fsi.model.BO.Etudiant;

import java.util.ArrayList;

public class EtudiantDAO {
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;

    public EtudiantDAO(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() {
        try {
            database = dbHelper.getWritableDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        database.close();
    }

    public Etudiant insertEtu(Etudiant monEtu) {
        ContentValues valeur = new ContentValues();
        valeur.put(MySQLiteHelper.COLUMN_NOM_ETU, monEtu.getNomEtu());
        valeur.put(MySQLiteHelper.COLUMN_PRE_ETU, monEtu.getPreEtu());
        valeur.put(MySQLiteHelper.COLUMN_TEL_ETU, monEtu.getTelEtu());
        valeur.put(MySQLiteHelper.COLUMN_MAIL_ETU, monEtu.getMailEtu());
        valeur.put(MySQLiteHelper.COLUMN_ETS_ETU, monEtu.getEtsEtu());
        valeur.put(MySQLiteHelper.COLUMN_TUT_ETS_ETU, monEtu.getTutEtsEtu());
        valeur.put(MySQLiteHelper.COLUMN_TUT_ECO, monEtu.getTutEtu());
        valeur.put(MySQLiteHelper.COLUMN_LOGIN_ETU, monEtu.getLoginEtu());
        valeur.put(MySQLiteHelper.COLUMN_MDP_ETU, monEtu.getMdpEtu());

        int id = (int) database.insert(MySQLiteHelper.TABLE_ETUDIANT, null, valeur);
        monEtu.setIdEtu(id);

        return monEtu;
    }

    public ArrayList<Etudiant> getAllEtu() {
        ArrayList<Etudiant> listEtu = new ArrayList<>();
        String[] colonnes = {
                MySQLiteHelper.COLUMN_ID_ETU,
                MySQLiteHelper.COLUMN_NOM_ETU,
                MySQLiteHelper.COLUMN_PRE_ETU,
                MySQLiteHelper.COLUMN_TEL_ETU,
                MySQLiteHelper.COLUMN_MAIL_ETU,
                MySQLiteHelper.COLUMN_ETS_ETU,
                MySQLiteHelper.COLUMN_TUT_ETS_ETU,
                MySQLiteHelper.COLUMN_TUT_ECO
        };

        Cursor curseur = database.query(MySQLiteHelper.TABLE_ETUDIANT, colonnes, null, null, null, null, null);
        while (curseur.moveToNext()) {
            Etudiant unEtu = getEtudiantFromCursor(curseur);
            listEtu.add(unEtu);
        }
        curseur.close();
        return listEtu;
    }

    public Etudiant getByIdEtu(int id) {
        Etudiant unEtu = null;
        String[] colonnes = {
                MySQLiteHelper.COLUMN_ID_ETU,
                MySQLiteHelper.COLUMN_NOM_ETU,
                MySQLiteHelper.COLUMN_PRE_ETU,
                MySQLiteHelper.COLUMN_TEL_ETU,
                MySQLiteHelper.COLUMN_MAIL_ETU,
                MySQLiteHelper.COLUMN_TUT_ETS_ETU,
                MySQLiteHelper.COLUMN_TUT_ECO
        };

        String selection = MySQLiteHelper.COLUMN_ID_ETU + " = ?";
        String[] selectionArgs = {String.valueOf(id)};

        Cursor curseur = database.query(MySQLiteHelper.TABLE_ETUDIANT, colonnes, selection, selectionArgs, null, null, null);
        if (curseur.moveToFirst()) { // Modification ici
            unEtu = getEtudiantFromCursor(curseur);
        }
        curseur.close();
        return unEtu;
    }

    public void deleteEtu(Etudiant unEtu) {
        int id = unEtu.getIdEtu();
        String selection = MySQLiteHelper.COLUMN_ID_ETU + " = ?";
        String[] selectionArgs = {String.valueOf(id)};
        database.delete(MySQLiteHelper.TABLE_ETUDIANT, selection, selectionArgs);
    }

    private Etudiant getEtudiantFromCursor(Cursor curseur) {
        int idEtu = curseur.getInt(curseur.getColumnIndex(MySQLiteHelper.COLUMN_ID_ETU));
        String nomEtu = curseur.getString(curseur.getColumnIndex(MySQLiteHelper.COLUMN_NOM_ETU));
        String preEtu = curseur.getString(curseur.getColumnIndex(MySQLiteHelper.COLUMN_PRE_ETU));
        String telEtu = curseur.getString(curseur.getColumnIndex(MySQLiteHelper.COLUMN_TEL_ETU));
        String mailEtu = curseur.getString(curseur.getColumnIndex(MySQLiteHelper.COLUMN_MAIL_ETU));
        String etsEtu = curseur.getString(curseur.getColumnIndex(MySQLiteHelper.COLUMN_ETS_ETU));
        String tutEtsEtu = curseur.getString(curseur.getColumnIndex(MySQLiteHelper.COLUMN_TUT_ETS_ETU));
        String tutEco = curseur.getString(curseur.getColumnIndex(MySQLiteHelper.COLUMN_TUT_ECO));
        return new Etudiant(idEtu, nomEtu, preEtu, telEtu, mailEtu, etsEtu, tutEtsEtu, tutEco);
    }
    public Etudiant getEtudiantByLoginMdp(String login, String mdp) {
        Etudiant etudiant = null;
        String selection = MySQLiteHelper.COLUMN_LOGIN_ETU + " = ? AND " + MySQLiteHelper.COLUMN_MDP_ETU + " = ?";
        String[] selectionArgs = {login, mdp};

        Cursor cursor = database.query(
                MySQLiteHelper.TABLE_ETUDIANT,
                null,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        if (cursor.moveToFirst()) {
            etudiant = getEtudiantFromCursor(cursor);
        }

        cursor.close();
        return etudiant;
    }
}
