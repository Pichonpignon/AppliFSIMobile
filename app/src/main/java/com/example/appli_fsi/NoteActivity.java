package com.example.appli_fsi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appli_fsi.model.BO.Etudiant;

public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        Etudiant etudiant = (Etudiant) getIntent().getSerializableExtra("etudiant");

        Button buttonBilanUn = findViewById(R.id.buttonBilanUn);
        Button buttonBilanDeux = findViewById(R.id.buttonBilanDeux);
        Button buttonRetour = findViewById(R.id.buttonRetourNote);

        buttonBilanUn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NoteActivity.this, BilanUnActivity.class);
                intent.putExtra("etudiant",etudiant);
                startActivity(intent);
            }
        });
        buttonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        buttonBilanDeux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NoteActivity.this, BilanDeuxActivity.class);
                intent.putExtra("etudiant", etudiant);
                startActivity(intent);
            }
        });
    }
}
