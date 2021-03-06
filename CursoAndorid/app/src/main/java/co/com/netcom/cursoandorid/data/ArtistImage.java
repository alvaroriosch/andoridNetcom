package co.com.netcom.cursoandorid.data;

import com.google.gson.annotations.SerializedName;

public class ArtistImage {

    @SerializedName("#text")
    String text;
    String size;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
