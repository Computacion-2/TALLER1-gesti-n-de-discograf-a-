package com.discography.service.impl;

import com.discography.model.Artist;
import com.discography.repository.IArtistRepository;
import com.discography.service.IArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("artistService")
public class ArtistServiceImpl implements IArtistService {


    private IArtistRepository artistRepository;

    @Autowired
    public ArtistServiceImpl(IArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }


    @Override
    public Artist getArtistByName(String name) {
        return artistRepository.getArtistByName(name);
    }

    @Override
    public List<Artist> getAllArtists() {
        return artistRepository.getAllArtists();
    }

    @Override
    public Artist save(Artist artist) {
        return artistRepository.save(artist);
    }

    @Override
    public Artist deleteById(int id) {
        return artistRepository.deleteById(id);
    }

    @Override
    public Artist getArtistById(int id) {
        return artistRepository.getArtistById(id);
    }

}
