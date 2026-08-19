package com.discography.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.discography.repository.IArtistRepository;
import com.discography.repository.ITrackRepository;
import com.discography.repository.impl.ArtistRepositoryImpl;
import com.discography.repository.impl.TrackRepositoryImpl;
import com.discography.service.IArtistService;
import com.discography.service.ITrackService;
import com.discography.service.impl.ArtistServiceImpl;
import com.discography.service.impl.TrackServiceImpl;

@Configuration
public class AppConfig {

    @Bean(initMethod = "init")
    public IArtistRepository artistRepository() {
        return new ArtistRepositoryImpl();
    }

    @Bean(initMethod = "init")
    public ITrackRepository trackRepository() {
        return new TrackRepositoryImpl(artistRepository());
    }

    @Bean
    public IArtistService artistService() {
        return new ArtistServiceImpl(artistRepository());
    }

    @Bean
    public ITrackService trackService() {
        return new TrackServiceImpl(trackRepository());
    }
}
