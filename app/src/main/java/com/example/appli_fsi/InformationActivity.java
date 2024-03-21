package com.example.appli_fsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.appli_fsi.model.BO.Etudiant;

public class InformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Button bouttonRetour = findViewById(R.id.buttonRetour);



        Etudiant etudiant = (Etudiant) getIntent().getSerializableExtra("etudiant");

        if (etudiant != null) {
            String prenom = etudiant.getPreEtu();
            TextView textViewPrenom = findViewById(R.id.textViewPrenom);
            textViewPrenom.setText(prenom + "");

            String nom = etudiant.getNomEtu();
            TextView textViewNom = findViewById(R.id.textViewName);
            textViewNom.setText(nom);

            String tel = etudiant.getTelEtu();
            TextView textViewPhone = findViewById(R.id.textViewPhone);
            textViewPhone.setText(tel);

            String mail = etudiant.getMailEtu();
            TextView textViewMail = findViewById(R.id.textViewMail);
            textViewMail.setText(mail);

            String ets = etudiant.getEtsEtu();
            TextView textViewSociete = findViewById(R.id.textViewSociete);
            textViewSociete.setText(ets);

            String tutets = etudiant.getTutEtsEtu();
            TextView textViewSocietyTutor = findViewById(R.id.textViewSocietyTutor);
            textViewSocietyTutor.setText(tutets);

            String tuteco = etudiant.getTutEtu();
            TextView textViewEcolTutor = findViewById(R.id.textViewEcolTutor);
            textViewEcolTutor.setText(tuteco);
        }
        bouttonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


    }
}

