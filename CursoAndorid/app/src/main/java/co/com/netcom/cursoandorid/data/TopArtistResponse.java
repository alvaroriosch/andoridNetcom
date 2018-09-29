package co.com.netcom.cursoandorid.data;

import com.google.gson.annotations.SerializedName;

public class TopArtistResponse {

    @SerializedName("topartists")
    TopArtists topartist;

    public TopArtists getTopartist() {
        return topartist;
    }

    public void setTopartist(TopArtists topartist) {
        this.topartist = topartist;
    }
}
