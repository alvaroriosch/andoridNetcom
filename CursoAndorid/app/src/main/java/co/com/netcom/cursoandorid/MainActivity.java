package co.com.netcom.cursoandorid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.netcom.cursoandorid.data.Artist;
import co.com.netcom.cursoandorid.presentation.adpaters.ArtistAdapter;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.lista_artistas)
    RecyclerView listaArtistas;

    ArrayList<Artist> artists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        setListaArtistas();

        LinearLayoutManager linearLayoutManagerVertical =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        ArtistAdapter adapter = new ArtistAdapter(this);
        adapter.addAll(artists);
        listaArtistas.setAdapter(adapter);
        listaArtistas.setLayoutManager(linearLayoutManagerVertical);
    }


    public void setListaArtistas(){
        artists = new ArrayList<Artist>();
        for (int i = 0; i< 10; i++) {
            Artist artist = new Artist();
            artist.setName("Artista " + i);
            artist.setListeners(10000);
            artist.setImage("http://i.imgur.com/DvpvklR.png");
            artists.add(artist);
        }
    }
}
