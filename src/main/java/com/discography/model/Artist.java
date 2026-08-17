package com.discography.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Artist {

    private int id;
    private String name;
    private String nationality;

    private List<Track> tracks;

    public Artist(int id, String name, String nationality) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.tracks = new ArrayList<>();
    }

    public boolean addTrack(Track track) {
        if (track != null && !this.tracks.contains(track)) {
            this.tracks.add(track);
            if (!track.getArtists().contains(this)) {
                track.getArtists().add(this);
            }
            return true;
        }
        return false;
    }

    public boolean removeTrack(Track track) {
        if (track != null && this.tracks.contains(track)) {
            this.tracks.remove(track);
            if (track.getArtists().contains(this)) {
                track.getArtists().remove(this);
            }
            return true;
        }
        return false;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return id == artist.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}