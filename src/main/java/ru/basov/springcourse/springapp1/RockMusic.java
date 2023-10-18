package ru.basov.springcourse.springapp1;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component("rockMusic")
public class RockMusic implements Music{
    private MusicType musicType = MusicType.ROCK;

    public MusicType getMusicType() {
        return musicType;
    }

    @Override
    public List<String> getSongs() {
        List<String> listMusic = Arrays.asList("KISH", "Leningrad", "Linkin Park");
        return listMusic;
    }
}
