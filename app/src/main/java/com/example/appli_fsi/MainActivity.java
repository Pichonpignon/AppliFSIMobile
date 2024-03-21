package com.example.appli_fsi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Date;
import java.util.Calendar;

import com.example.appli_fsi.model.BO.Etudiant;
import com.example.appli_fsi.model.DAO.EtudiantDAO;
import com.example.appli_fsi.model.DAO.MySQLiteHelper;
import com.example.appli_fsi.model.BO.BilanUn;
import com.example.appli_fsi.model.BO.BilanDeux;

public class MainActivity extends AppCompatActivity {
    EditText editTextLogin, editTextMdp;
    Button buttonLogin;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextLogin = findViewById(R.id.editTextUsername);
        editTextMdp = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        Etudiant etu = new Etudiant();
        etu.setIdEtu(1);
        etu.setNomEtu("Doe");
        etu.setPreEtu("John");
        etu.setTelEtu("0898798");
        etu.setMailEtu("ghubefo");
        etu.setEtsEtu("kubf");
        etu.setTutEtsEtu("uviui");
        etu.setTutEtu("iub");
        etu.setMdpEtu("doe");
        etu.setLoginEtu("john");

        BilanUn bilanUn = new BilanUn();
        bilanUn.setIdBilanUn(1);
        bilanUn.setRqBilanUn("uyvieudviubvu");
        bilanUn.setNoteEts(12);
        bilanUn.setNoteOralUn(16);
        bilanUn.setNoteDossierUn(11);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2024);
        calendar.set(Calendar.MONTH, calendar.MAY);
        calendar.set(Calendar.DAY_OF_MONTH, 15);
        Date date = calendar.getTime();
        bilanUn.setDateBilanUn(date);

        BilanDeux bilanDeux = new BilanDeux();
        bilanDeux.setIdBilanDeux(12);
        bilanDeux.setNoteDossierDeux(12);
        bilanDeux.setNoteOralDeux(13);
        bilanDeux.setSujetMemoire("yufivuvb");
        bilanDeux.setRqBilanDeux("iufiiuvbouboi");

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.YEAR, 2024);
        calendar1.set(Calendar.MONTH, calendar1.OCTOBER);
        calendar1.set(Calendar.DAY_OF_MONTH, 16);
        Date date1 = calendar1.getTime();
        bilanDeux.setDateBilanDeux(date1);

        etu.setMonBilanDeux(bilanDeux);
        etu.setMonBilanUn(bilanUn);


        /*EtudiantDAO etudiantDAO = new EtudiantDAO(this);
        etudiantDAO.open();
        etudiantDAO.insertEtu(etu);
        etudiantDAO.close();

        MySQLiteHelper dbHelper = new MySQLiteHelper(this);
        db = dbHelper.getWritableDatabase();*/

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = editTextLogin.getText().toString().trim();
                String mdp = editTextMdp.getText().toString().trim();

                if(etu.getLoginEtu().equals(login) && etu.getMdpEtu().equals(mdp)){
                    Intent intent = new Intent(MainActivity.this, AccueilActivity.class);
                    intent.putExtra("etudiant",etu);
                    startActivity(intent);
                    //finish();
                }else  {
                    Toast.makeText(MainActivity.this,"Login ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                }

               /* if(verifMdp(login,mdp)){
                    Intent intent = new Intent(MainActivity.this, AccueilActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(MainActivity.this, "Login ou Mot de Passe incorrect", Toast.LENGTH_SHORT).show();
                }*/
            }
        });
    }

    private boolean verifMdp(String login, String mdp){
        String[] colonne = {"loginEtu", "mdpEtu"};
        String selection = "loginEtu=? AND mdpEtu=?";
        String[] selctionArgs = {login, mdp};

        Cursor cursor = db.query(MySQLiteHelper.TABLE_ETUDIANT, colonne, selection, selctionArgs, null, null,null);
        boolean valid = cursor.moveToFirst();
        cursor.close();
        return valid;
    }
}
