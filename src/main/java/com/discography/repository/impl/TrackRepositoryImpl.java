package com.discography.repository.impl;

import com.discography.model.Artist;
import com.discography.model.Track;
import com.discography.repository.IArtistRepository;
import com.discography.repository.ITrackRepository;
import java.util.List;
import java.util.ArrayList;

public class TrackRepositoryImpl implements ITrackRepository {

    private List<Track> tracks = new ArrayList<>();
    private IArtistRepository artistRepository;
    private static int idCounter = 1;

    public TrackRepositoryImpl(IArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public Track save(Track track, List<Integer> artistIds) {

        track.setId(idCounter++);
        tracks.add(track);

        for (Integer artistId : artistIds) {
            Artist artist = artistRepository.getArtistById(artistId);
            if (artist != null) {
                artist.addTrack(track);
            }
        }

        return track;
    }

    @Override
    public Track getTrackById(int id) {

        for (Track track : tracks) {
            if (track.getId() == id) {
                return track;
            }
        }
        return null;
    }

    @Override
    public List<Track> getAllTracks() {

        return tracks;
    }

    @Override
    public Track deleteById(int id) {

        for (Track track : tracks) {
            if (track.getId() == id) {
                tracks.remove(track);
                return track;
            }
        }
        return null;
    }

}
