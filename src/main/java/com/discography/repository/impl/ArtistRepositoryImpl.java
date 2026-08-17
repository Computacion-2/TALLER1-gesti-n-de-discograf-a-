package com.discography.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.discography.model.Artist;
import com.discography.model.Track;
import com.discography.repository.IArtistRepository;

public class ArtistRepositoryImpl implements IArtistRepository {

    private List<Artist> artists = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public void init() {
        artists.clear();
        artists.add(new Artist(idCounter++, "Queen", "UK"));
        artists.add(new Artist(idCounter++, "Pink Floyd", "UK"));
        artists.add(new Artist(idCounter++, "AC/DC", "Australia"));
        artists.add(new Artist(idCounter++, "Michael Jackson", "USA"));
        artists.add(new Artist(idCounter++, "The Beatles", "UK"));
        artists.add(new Artist(idCounter++, "Led Zeppelin", "UK"));
        artists.add(new Artist(idCounter++, "Metallica", "USA"));
        artists.add(new Artist(idCounter++, "The Rolling Stones", "UK"));
        artists.add(new Artist(idCounter++, "Guns N' Roses", "USA"));
        artists.add(new Artist(idCounter++, "Aerosmith", "USA"));
    }

    @Override
    public Artist save(Artist artist) {
        artist.setId(idCounter++);
        artists.add(artist);
        return artist;
    }

    @Override
    public Artist getArtistById(int id) {
        for (Artist artist : artists) {
            if (artist.getId() == id) {
                return artist;
            }
        }
        return null;
    }

    @Override
    public List<Artist> getAllArtists() {
        return artists;
    }

    @Override
    public Artist deleteById(int id) {
        for (Artist artist : artists) {
            if (artist.getId() == id) {
                artists.remove(artist);
                List<Track> associatedTracks = new ArrayList<>(artist.getTracks());
                for (Track track : associatedTracks) {
                    track.removeArtist(artist);
                }
                return artist;
            }
        }
        return null;
    }

    @Override
    public Artist getArtistByName(String name) {
        for (Artist artist : artists) {
            if (artist.getName().equalsIgnoreCase(name)) {
                return artist;
            }
        }
        return null;
    }
}
