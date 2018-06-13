package by.epam.training.bean.artist;

import java.util.ArrayList;
import java.util.List;

import by.epam.training.bean.track.Track;

public class Album {

    private String name;

    private List<Song> songList = new ArrayList<>();

    public Album (Track track) {
        this.name = track.getAlbumName();
        addSong(track);
    }

    public void addSong(Track track) {
        songList.add(new Song(track));
    }

    public List<Song> getSongList() {
        return songList;
    }

    public String getAlbumName() {
        return name;
    }
}
