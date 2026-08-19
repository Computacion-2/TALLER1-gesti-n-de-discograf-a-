package com.discography.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.discography.model.Track;
import com.discography.repository.ITrackRepository;
import com.discography.service.ITrackService;

@Service("trackService")
public class TrackServiceImpl implements ITrackService {


    private ITrackRepository trackRepository;

    @Autowired
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

