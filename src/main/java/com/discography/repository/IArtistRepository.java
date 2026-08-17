package com.discography.repository;

import com.discography.model.Artist;
import java.util.List;

public interface IArtistRepository {

    Artist getArtistByName(String name);

    List<Artist> getAllArtists();

    Artist save(Artist artist);

    Artist deleteById(int id);

    Artist getArtistById(int id);

}
