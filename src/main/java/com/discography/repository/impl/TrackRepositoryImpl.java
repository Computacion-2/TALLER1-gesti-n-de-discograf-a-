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
    private int idCounter = 1;

    public TrackRepositoryImpl(IArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public void init() { // 5 tracks per artist (50 total tracks for 10 artists)
        tracks.clear();

        // Tracks de Queen
        tracks.add(new Track(idCounter++, "Bohemian Rhapsody", "Rock", "5:55", "A Night at the Opera"));
        tracks.add(new Track(idCounter++, "We Will Rock You", "Rock", "2:02", "News of the World"));
        tracks.add(new Track(idCounter++, "Dont Stop Me Now", "Rock", "3:29", "Jazz"));
        tracks.add(new Track(idCounter++, "Under Pressure", "Rock", "4:05", "Hot Space"));
        tracks.add(new Track(idCounter++, "Somebody to Love", "Rock", "4:56", "A Day at the Races"));

        // Tracks de Pink Floyd
        tracks.add(new Track(idCounter++, "Shine On You Crazy Diamond", "Progressive Rock", "13:30",
                "Wish You Were Here"));
        tracks.add(new Track(idCounter++, "Comfortably Numb", "Progressive Rock", "6:23", "The Wall"));
        tracks.add(new Track(idCounter++, "Money", "Progressive Rock", "6:23", "The Wall"));
        tracks.add(new Track(idCounter++, "Time", "Progressive Rock", "6:23", "The Wall"));
        tracks.add(new Track(idCounter++, "Wish You Were Here", "Progressive Rock", "6:23", "The Wall"));

        // Tracks de AC/DC
        tracks.add(new Track(idCounter++, "Back in Black", "Hard Rock", "4:15", "Back in Black"));
        tracks.add(new Track(idCounter++, "Highway to Hell", "Hard Rock", "3:28", "Highway to Hell"));
        tracks.add(new Track(idCounter++, "Thunderstruck", "Hard Rock", "4:52", "The Razors Edge"));
        tracks.add(new Track(idCounter++, "Hells Bells", "Hard Rock", "5:12", "Back in Black"));
        tracks.add(new Track(idCounter++, "You Shook Me All Night Long", "Hard Rock", "3:30", "Back in Black"));

        // Tracks de Michael Jackson
        tracks.add(new Track(idCounter++, "Billie Jean", "Pop", "4:54", "Thriller"));
        tracks.add(new Track(idCounter++, "Beat It", "Rock", "4:18", "Thriller"));
        tracks.add(new Track(idCounter++, "Thriller", "Pop", "5:57", "Thriller"));
        tracks.add(new Track(idCounter++, "Smooth Criminal", "Pop", "4:17", "Bad"));
        tracks.add(new Track(idCounter++, "Black or White", "Pop", "4:18", "Dangerous"));

        // Tracks de The Beatles
        tracks.add(new Track(idCounter++, "Hey Jude", "Rock", "7:11", "The Beatles (White Album)"));
        tracks.add(new Track(idCounter++, "Let It Be", "Rock", "4:03", "Let It Be"));
        tracks.add(new Track(idCounter++, "Yesterday", "Rock", "2:05", "Help!"));
        tracks.add(new Track(idCounter++, "Come Together", "Rock", "4:20", "Abbey Road"));
        tracks.add(new Track(idCounter++, "Something", "Rock", "3:03", "Abbey Road"));

        // Tracks de Led Zeppelin
        tracks.add(new Track(idCounter++, "Stairway to Heaven", "Rock", "8:02", "Led Zeppelin IV"));
        tracks.add(new Track(idCounter++, "Kashmir", "Progressive Rock", "8:31", "Led Zeppelin III"));
        tracks.add(new Track(idCounter++, "Whole Lotta Love", "Hard Rock", "5:34", "Led Zeppelin II"));
        tracks.add(new Track(idCounter++, "Immigrant Song", "Hard Rock", "2:25", "Led Zeppelin III"));
        tracks.add(new Track(idCounter++, "Black Dog", "Blues Rock", "4:55", "Led Zeppelin IV"));

        // Tracks de Metallica
        tracks.add(new Track(idCounter++, "Enter Sandman", "Heavy Metal", "5:31", "Metallica"));
        tracks.add(new Track(idCounter++, "Nothing Else Matters", "Heavy Metal", "6:28", "Metallica"));
        tracks.add(new Track(idCounter++, "Master of Puppets", "Heavy Metal", "8:35", "Master of Puppets"));
        tracks.add(new Track(idCounter++, "One", "Thrash Metal", "7:24", "...And Justice for All"));
        tracks.add(new Track(idCounter++, "Fade to Black", "Heavy Metal", "6:59", "Kill 'Em All"));

        // Tracks de The Rolling Stones
        tracks.add(new Track(idCounter++, "(I Can't Get No) Satisfaction", "Rock", "3:43", "Out of Our Heads"));
        tracks.add(new Track(idCounter++, "Paint It, Black", "Rock", "3:45", "Aftermath"));
        tracks.add(new Track(idCounter++, "Sympathy for the Devil", "Rock", "6:18", "Beggars Banquet"));
        tracks.add(new Track(idCounter++, "Jumpin' Jack Flash", "Rock", "3:42", "Street Fighting Man"));
        tracks.add(new Track(idCounter++, "Angie", "Rock", "4:32", "Goats Head Soup"));

        // Tracks de Guns N' Roses
        tracks.add(new Track(idCounter++, "Sweet Child o' Mine", "Hard Rock", "5:56", "Appetite for Destruction"));
        tracks.add(new Track(idCounter++, "November Rain", "Power Ballad", "8:57", "Use Your Illusion I"));
        tracks.add(new Track(idCounter++, "Welcome to the Jungle", "Hard Rock", "4:31", "Appetite for Destruction"));
        tracks.add(new Track(idCounter++, "Paradise City", "Hard Rock", "6:46", "Appetite for Destruction"));
        tracks.add(new Track(idCounter++, "Patience", "Acoustic Rock", "5:56", "G N' R Lies"));

        // Tracks de Aerosmith
        tracks.add(new Track(idCounter++, "Dream On", "Rock", "4:28", "Aerosmith"));
        tracks.add(new Track(idCounter++, "I Don't Want to Miss a Thing", "Power Ballad", "4:58", "Armageddon"));
        tracks.add(new Track(idCounter++, "Walk This Way", "Hard Rock", "3:40", "Toys in the Attic"));
        tracks.add(new Track(idCounter++, "Cryin'", "Power Ballad", "5:08", "Get a Grip"));
        tracks.add(new Track(idCounter++, "Janie's Got a Gun", "Hard Rock", "5:38", "Pump"));

        List<Artist> artists = artistRepository.getAllArtists();
        for (int i = 0; i < artists.size(); i++) {
            Artist artist = artists.get(i);
            for (int j = i * 5; j < (i + 1) * 5 && j < tracks.size(); j++) {
                Track track = tracks.get(j);
                artist.addTrack(track);
            }
        }
    }

    @Override
    public Track save(Track track, List<Integer> artistIds) {
        track.setId(idCounter++);
        tracks.add(track);

        if (artistIds != null) {
            for (Integer artistId : artistIds) {
                Artist artist = artistRepository.getArtistById(artistId);
                if (artist != null) {
                    artist.addTrack(track);
                }
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

                List<Artist> associatedArtists = new ArrayList<>(track.getArtists());
                for (Artist artist : associatedArtists) {
                    artist.removeTrack(track);
                }
                return track;
            }
        }
        return null;
    }
}
