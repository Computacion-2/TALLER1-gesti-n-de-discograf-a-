package com.discography.repository;

import com.discography.model.Track;
import java.util.List;

public interface ITrackRepository {

    List<Track> getAllTracks();

    Track getTrackById(int id);

    Track save(Track track, List<Integer> artistId);

    Track deleteById(int id);

}
