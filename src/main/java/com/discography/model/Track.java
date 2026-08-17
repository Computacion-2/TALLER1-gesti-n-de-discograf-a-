package com.discography.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Track {

    private int id;
    private String title;
    private String genre;
    private String duration;
    private String albumTitle;

    private List<Artist> artists;

    public Track(int id, String title, String genre, String duration, String albumTitle) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.albumTitle = albumTitle;
        this.artists = new ArrayList<>();
    }

    public boolean addArtist(Artist artist) {
        if (artist != null && !this.artists.contains(artist)) {
            this.artists.add(artist);
            if (!artist.getTracks().contains(this)) {
                artist.getTracks().add(this);
            }
            return true;
        }
        return false;
    }

    public boolean removeArtist(Artist artist) {
        if (artist != null && this.artists.contains(artist)) {
            this.artists.remove(artist);
            if (artist.getTracks().contains(this)) {
                artist.getTracks().remove(this);
            }
            return true;
        }
        return false;
    }

    public List<Artist> getArtists() {
        return artists;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return id == track.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

