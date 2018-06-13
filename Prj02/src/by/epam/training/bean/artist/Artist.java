package by.epam.training.bean.artist;

import java.util.HashMap;
import java.util.LinkedHashMap;

import by.epam.training.bean.track.Track;


public class Artist {

    private String name;
    private Track track;
    private HashMap<String, Album> albumMap = new LinkedHashMap<>();

    public Artist(Track track) {
        this.track = track;
        this.name = track.getArtistName();
        addAlbum(track);
    }


    public HashMap<String, Album> getAlbumMap() {
        return albumMap;
    }

    public void addAlbum(Track track) {
        if (albumMap.containsKey(track.getAlbumName())) {
            albumMap.get(track.getAlbumName()).addSong(track);
        } else {
            albumMap.put(track.getAlbumName(), new Album(track));
        }
    }
}
