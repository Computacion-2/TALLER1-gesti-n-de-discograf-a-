package com.discography.service.impl;

import java.util.List;

import com.discography.model.Track;
import com.discography.repository.ITrackRepository;

public class TrackServiceImpl implements ITrackRepository {

    private ITrackRepository trackRepository;

    public TrackServiceImpl(ITrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @Override
    public List<Track> getAllTracks() {
        return trackRepository.getAllTracks();
    }

    @Override
    public Track getTrackById(int id) {
        return trackRepository.getTrackById(id);
    }

    @Override
    public Track save(Track track, List<Integer> artistId) {
        return trackRepository.save(track, artistId);
    }

    @Override
    public Track deleteById(int id) {
        return trackRepository.deleteById(id);
    }

}
