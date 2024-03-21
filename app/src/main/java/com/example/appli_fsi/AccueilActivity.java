package com.example.appli_fsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.appli_fsi.model.BO.Etudiant;
import com.example.appli_fsi.model.DAO.EtudiantDAO;
import com.example.appli_fsi.model.DAO.MySQLiteHelper;

public class AccueilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        Etudiant etudiant = (Etudiant) getIntent().getSerializableExtra("etudiant");

        if(etudiant!=null){
            String preEtu = etudiant.getPreEtu();
            TextView textViewAccueil = findViewById(R.id.textViewWelcome);
            textViewAccueil.setText("Bienvenue " + preEtu + " !");
        }

        Button buttonNotes = findViewById(R.id.buttonNotes);
        Button buttonInfo = findViewById(R.id.buttonStudentInfo);

        buttonNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccueilActivity.this, NoteActivity.class);
                intent.putExtra("etudiant",etudiant);
                startActivity(intent);
            }
        });

        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccueilActivity.this, InformationActivity.class);
                intent.putExtra("etudiant",etudiant);
                startActivity(intent);
            }
        });
    }
}
