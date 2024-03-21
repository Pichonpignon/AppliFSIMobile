package com.example.appli_fsi.model.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.appli_fsi.model.BO.Etudiant;

import java.util.ArrayList;

public class EtudiantDAO {
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;

    public EtudiantDAO(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public Etudiant insertEtu(Etudiant monEtu){
        ContentValues valeur = new ContentValues();
        valeur.put("nomEtu", monEtu.getNomEtu());
        valeur.put("preEtu", monEtu.getPreEtu());
        valeur.put("telEtu", monEtu.getTelEtu());
        valeur.put("mailEtu", monEtu.getMailEtu());
        valeur.put("etsEtu", monEtu.getEtsEtu());
        valeur.put("tutEtsEtu", monEtu.getTutEtsEtu());
        valeur.put("tutEco", monEtu.getTutEtu());
        int id = (int) database.insert("Etudiant",null,valeur);
        monEtu.setIdEtu(id);

        return monEtu;
    }

    public ArrayList<Etudiant> getAllEtu(){
        ArrayList<Etudiant> listEtu = new ArrayList<>();
        Cursor curseur = database.query(true,"Etudiant",new String[]{"idEtu","nomEtu","preEtu","telEtu","mailEtu","etsEtu","tutEtsEtu","tutEco"},
                null,null,null,null,null,null);
        while (curseur.moveToNext()){
            int idEtu = curseur.getInt(curseur.getColumnIndex("idEtu"));
            String nomEtu = curseur.getString(curseur.getColumnIndex("nomEtu"));
            String preEtu = curseur.getString(curseur.getColumnIndex("preEtu"));
            String telEtu = curseur.getString(curseur.getColumnIndex("telEtu"));
            String mailEtu = curseur.getString(curseur.getColumnIndex("mailEtu"));
            String etsEtu = curseur.getString(curseur.getColumnIndex("etsEtu"));
            String tutEtsEtu = curseur.getString(curseur.getColumnIndex("tutEtsEtu"));
            String tutEco = curseur.getString(curseur.getColumnIndex("tutEtu"));
            Etudiant unEtu = new Etudiant(idEtu,nomEtu,preEtu,telEtu,mailEtu,etsEtu,tutEtsEtu,tutEco);
            listEtu.add(unEtu);
        }
        curseur.close();
        return listEtu;
    }
    public Etudiant getByIdEtu(int id){
        Etudiant unEtu = null;
        Cursor curseur = database.query(true, "Etudiant", new String[]{"idEtu","nomEtu","preEtu","telEtu","mailEtu","tutEtsEtu","tutEtu"},
                "idEtu = " + id, null, null, null, null, null);
        while (curseur.moveToNext()){
            String nomEtu = curseur.getString(curseur.getColumnIndex("nomEtu"));
            String preEtu = curseur.getString(curseur.getColumnIndex("preEtu"));
            String telEtu = curseur.getString(curseur.getColumnIndex("telEtu"));
            String mailEtu = curseur.getString(curseur.getColumnIndex("mailEtu"));
            String etsEtu = curseur.getString(curseur.getColumnIndex("etsEtu"));
            String tutEtsEtu = curseur.getString(curseur.getColumnIndex("tutEtsEtu"));
            String tutEtu = curseur.getString(curseur.getColumnIndex("tutEtu"));
            unEtu = new Etudiant(id,nomEtu,preEtu,telEtu,mailEtu,etsEtu,tutEtsEtu,tutEtu);
        }
        curseur.close();
        return unEtu;
    }

    public void deleteEtu(Etudiant unEtu){
        int id = unEtu.getIdEtu();
        database.delete(MySQLiteHelper.TABLE_ETUDIANT,"idEtu = "+id, null);
    }
}
