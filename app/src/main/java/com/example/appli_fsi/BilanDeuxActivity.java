package com.example.appli_fsi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import com.example.appli_fsi.model.BO.BilanDeux;
import com.example.appli_fsi.model.BO.Etudiant;

public class BilanDeuxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilandeux);

        Button buttonRetour = findViewById(R.id.buttonRetourBilanDeux);
        Etudiant etudiant = (Etudiant) getIntent().getSerializableExtra("etudiant");

        if(etudiant!=null){
            BilanDeux bilanDeux = etudiant.getMonBilanDeux();
            if(bilanDeux!=null){
                TextView noteDossierDeuxTextView = findViewById(R.id.noteDossierDeux);
                float noteDossierDeux = bilanDeux.getNoteDossierDeux();
                String noteDossierDeuxStr = String.valueOf(noteDossierDeux);
                noteDossierDeuxTextView.setText(noteDossierDeuxStr);

                TextView noteOralDeuxTextView = findViewById(R.id.noteOralDeux);
                float noteOralDeux = bilanDeux.getNoteOralDeux();
                String noteOralDeuxStr = String.valueOf(noteOralDeux);
                noteOralDeuxTextView.setText(noteOralDeuxStr);
            }
        }
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}

