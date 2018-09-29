package co.com.netcom.cursoandorid.domain;

import java.util.List;

import co.com.netcom.cursoandorid.data.Artist;
import co.com.netcom.cursoandorid.data.TopArtistResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiAdapter {

    @GET("/2.0/?method=geo.gettopartists&format=json")
    Call<TopArtistResponse> getTopArtist(
            @Query("country") String country,
            @Query("api_key") String apiKey);
}
