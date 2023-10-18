package ru.basov.springcourse.springapp1;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component("rockMusic")
public class RockMusic implements Music{
    @Override
    public List<String> getSongs() {
        List<String> listMusic = Arrays.asList("KISH", "Leningrad", "Linkin Park");
        return listMusic;
    }
}
