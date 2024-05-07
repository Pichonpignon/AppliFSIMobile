package com.example.appli_fsi;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appli_fsi.model.BO.APIService;
import com.example.appli_fsi.model.BO.Etudiant;
import com.example.appli_fsi.model.BO.RetrofitClient;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText editTextLogin, editTextMdp;
    private Button buttonLogin;
    private Etudiant etudiant;
    private RetrofitClient retrofitClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextLogin = findViewById(R.id.editTextUsername);
        editTextMdp = findViewById(R.id.editTextPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        retrofitClient = RetrofitClient.getInstance();

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = editTextLogin.getText().toString().trim();
                String mdp = editTextMdp.getText().toString().trim();

                authenticateUser(login, mdp);
            }
        });
    }

    private void authenticateUser(String login, String mdp) {
        Call<Etudiant> call = retrofitClient.getMyApi().getEtudiant(login, mdp);

        call.enqueue(new Callback<Etudiant>() {
            @Override
            public void onResponse(Call<Etudiant> call, Response<Etudiant> response) {
                if (response.isSuccessful()) {
                    etudiant = response.body();
                    redirectToAccueil(etudiant);
                } else {
                    Toast.makeText(MainActivity.this, "Login ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Etudiant> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Erreur de connexion", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void redirectToAccueil(Etudiant etudiant) {
        Intent intent = new Intent(MainActivity.this, AccueilActivity.class);
        intent.putExtra("etudiant", etudiant);
        startActivity(intent);
    }
}