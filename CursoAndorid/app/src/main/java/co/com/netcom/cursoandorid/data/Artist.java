package co.com.netcom.cursoandorid.data;

import java.util.List;

public class Artist {

    String name;
    List<ArtistImage> image;
    int listeners;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ArtistImage> getImage() {
        return image;
    }

    public void setImage(List<ArtistImage> image) {
        this.image = image;
    }

    public int getListeners() {
        return listeners;
    }

    public void setListeners(int listeners) {
        this.listeners = listeners;
    }
}
