package com.example.appimporvultec.retrofit;

import com.example.appimporvultec.constantes.constantes;
import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImportVulteClient {

    private static ImportVulteClient instance=null;

    private ImportVultecService importVultecService;

    private Retrofit retrofit;

    public ImportVulteClient() {
        retrofit=new Retrofit.Builder().baseUrl(constantes.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        importVultecService=retrofit.create(ImportVultecService.class);
    }

    public static ImportVulteClient getInstance(){
        if(instance==null){
            instance=new ImportVulteClient();
        }
        return instance;
    }

    public ImportVultecService getImportVultecService(){

        return importVultecService;

    }

}
