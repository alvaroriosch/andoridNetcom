package co.com.netcom.cursoandorid.presentation.adpaters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import co.com.netcom.cursoandorid.R;
import co.com.netcom.cursoandorid.data.Artist;

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder> {




    ArrayList<Artist> artits;
    Context mContext;

    public ArtistAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ArtistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.artist_view, parent, false);

        ArtistViewHolder vh = new ArtistViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistViewHolder artistViewHolder, int i) {
        Artist artist = artits.get(i);

        artistViewHolder.setArtistImage(artist.getImage());
        artistViewHolder.setArtistName(artist.getName());
        artistViewHolder.setArtistListener(artist.getListeners());
    }

    @Override
    public int getItemCount() {
        return artits.size();
    }

    public void addAll(ArrayList<Artist> artists){
        this.artits = artists;
    }

    class ArtistViewHolder extends RecyclerView.ViewHolder {

        ImageView artistImage;
        TextView artistName;
        TextView artistListeners;

        public ArtistViewHolder(@NonNull View itemView) {
            super(itemView);

            artistImage = (ImageView) itemView.findViewById(R.id.artist_image);
            artistName = (TextView) itemView.findViewById(R.id.artist_name);
            artistListeners = (TextView) itemView.findViewById(R.id.artist_listeners);
        }

        public void setArtistName(String name) {
            artistName.setText(name);
        }

        public void setArtistListener(int listeners) {
            artistListeners.setText(String.valueOf(listeners));
        }

        public void setArtistImage(String url) {
            Picasso.get().load(url).into(artistImage);
        }
    }
}
