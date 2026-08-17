package com.discography.service.impl;

import java.util.List;

import com.discography.model.Track;
import com.discography.repository.ITrackRepository;
import com.discography.service.ITrackService;

public class TrackServiceImpl implements ITrackService {

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
    public Track save(Track track, List<Integer> artistIds) {
        return trackRepository.save(track, artistIds);
    }

    @Override
    public Track deleteById(int id) {
        return trackRepository.deleteById(id);
    }

}

