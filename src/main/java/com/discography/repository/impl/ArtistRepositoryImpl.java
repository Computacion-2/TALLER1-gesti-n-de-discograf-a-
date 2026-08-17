package com.discography.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.discography.model.Artist;
import com.discography.repository.IArtistRepository;

public class ArtistRepositoryImpl implements IArtistRepository {

    private List<Artist> artists = new ArrayList<>();

    private static int idCounter = 1;

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
                return artist;
            }
        }
        return null;
    }

    @Override
    public Artist getArtistByName(String name) {
        for (Artist artist : artists) {
            if (artist.getName().equals(name)) {
                return artist;
            }
        }
        return null;
    }

}
