package com.example.appli_fsi.model.BO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIService {
    String BASE_URL = "https://olen-ort.fr/p2024/Ma2l/api.php/";

    @GET("Etudiant")
    Call<Etudiant> getEtudiant(@Query("identifiant") String login, @Query("mdpUtilisateur") String mdp);

}
