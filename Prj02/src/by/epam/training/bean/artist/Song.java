package by.epam.training.bean.artist;

import by.epam.training.bean.track.Track;

public class Song {

    private String name;
    private long duration;
    private String path;

    public Song(Track track) {
        this.name = track.getSongName();
        this.duration = track.getSongDuration();
        this.path = track.getPath();
    }

    public String getName() {
        return name;
    }

    public long getDuration() {
        return duration;
    }

    public String getPath() {
        return path;
    }
}
