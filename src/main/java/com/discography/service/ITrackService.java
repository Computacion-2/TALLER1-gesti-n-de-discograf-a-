package com.discography.service;

import java.util.List;

import com.discography.model.Track;

public interface ITrackService {

    List<Track> getAllTracks();

    Track getTrackById(int id);

    Track save(Track track, List<Integer> artistId);

    Track deleteById(int id);

}
