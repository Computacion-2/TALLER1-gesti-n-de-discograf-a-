package com.discography.service;

import java.util.List;

import com.discography.model.Artist;

public interface IArtistService {

    Artist getArtistByName(String name);

    List<Artist> getAllArtists();

    Artist save(Artist artist);

    Artist deleteById(int id);

    Artist getArtistById(int id);

}
