package co.com.netcom.cursoandorid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.telecom.Call;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.netcom.cursoandorid.data.Artist;
import co.com.netcom.cursoandorid.data.TopArtistResponse;
import co.com.netcom.cursoandorid.domain.ApiAdapter;
import co.com.netcom.cursoandorid.domain.ApiBuilder;
import co.com.netcom.cursoandorid.presentation.adpaters.ArtistAdapter;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements Callback<TopArtistResponse> {

    public static Logger LOG = Logger.getLogger(MainActivity.class.getName());

    @BindView(R.id.lista_artistas)
    RecyclerView listaArtistas;

    ArrayList<Artist> artists;

    ArtistAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        //setListaArtistas();

        LinearLayoutManager linearLayoutManagerVertical =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        adapter = new ArtistAdapter(this);
        //adapter.addAll(artists);

        listaArtistas.setLayoutManager(linearLayoutManagerVertical);
    }

    @Override
    protected void onResume() {
        super.onResume();

        ApiAdapter apiAdapter = ApiBuilder.getAPiadapter();

        retrofit2.Call<TopArtistResponse> call = apiAdapter.getTopArtist(
                "colombia",
                getString(R.string.last_fm_key)
        );

        call.enqueue(this);

    }

    public void setListaArtistas(){
        artists = new ArrayList<Artist>();
        for (int i = 0; i< 10; i++) {
            Artist artist = new Artist();
            artist.setName("Artista " + i);
            artist.setListeners(10000);
            //artist.setImage("http://i.imgur.com/DvpvklR.png");
            artists.add(artist);
        }
    }

    @Override
    public void onResponse(retrofit2.Call<TopArtistResponse> call, Response<TopArtistResponse> response) {
        LOG.info("Respondió");

        try {
            LOG.info(response.body().getTopartist().getArtist().get(0).getName() + "");

            adapter.addAll(response.body().getTopartist().getArtist());
            listaArtistas.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onFailure(retrofit2.Call<TopArtistResponse> call, Throwable t) {
        LOG.info("Falló");
        LOG.info(call.request().url().toString());
        LOG.info(t.getMessage());
    }
}
