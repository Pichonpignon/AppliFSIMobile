package com.example.appli_fsi.model.BO;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
   private static RetrofitClient instance;
   private APIService myApi;

   private RetrofitClient(){
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(APIService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi =retrofit.create(APIService.class);
   }

   public static RetrofitClient getInstance(){
        if(instance == null){
            instance = new RetrofitClient();
        }
        return instance;
   }

    public APIService getMyApi() {
        return myApi;
    }

    public void setMyApi(APIService myApi) {
        this.myApi = myApi;
    }
}