package com.example.appli_fsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.io.Serializable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appli_fsi.model.BO.BilanUn;
import com.example.appli_fsi.model.BO.Etudiant;

public class BilanUnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilanun);

        Button buttonRetour = findViewById(R.id.buttonRetourBilanUn);
        Etudiant etudiant = (Etudiant) getIntent().getSerializableExtra("etudiant");

        if(etudiant!=null){
            BilanUn bilanUn = etudiant.getMonBilanUn();
            if(bilanUn!=null){
                TextView noteEtsTextView = findViewById(R.id.noteEtsBilanUn);
                float noteEts = bilanUn.getNoteEts();
                String noteEtsStr = String.valueOf(noteEts);
                noteEtsTextView.setText(noteEtsStr);

                TextView noteDossierUnTextView = findViewById(R.id.noteDossierUn);
                float noteDossierUn = bilanUn.getNoteDossierUn();
                String noteDossierUnStr = String.valueOf(noteDossierUn);
                noteDossierUnTextView.setText(noteDossierUnStr);

                TextView noteOralUnTextView = findViewById(R.id.noteOralUn);
                float noteOralUn = bilanUn.getNoteOralUn();
                String noteOralUnStr = String.valueOf(noteOralUn);
                noteOralUnTextView.setText(noteOralUnStr);
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

