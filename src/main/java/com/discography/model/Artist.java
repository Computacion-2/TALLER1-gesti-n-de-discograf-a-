package com.discography.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
        return this.tracks.add(track);
    }

    public boolean removeTrack(Track track) {
        return this.tracks.remove(track);
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

}