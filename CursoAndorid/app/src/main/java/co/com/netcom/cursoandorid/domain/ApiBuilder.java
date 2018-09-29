package co.com.netcom.cursoandorid.domain;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiBuilder {

    public static ApiAdapter API_SERVICE;
    public static ApiAdapter getAPiadapter() {

        if(API_SERVICE == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://ws.audioscrobbler.com")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            API_SERVICE = retrofit.create(ApiAdapter.class);
        }

        return API_SERVICE;
    }
}
