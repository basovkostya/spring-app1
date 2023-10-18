package ru.basov.springcourse.springapp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component("classicalMusic")
public class ClassicalMusic implements Music{
    private MusicType musicType = MusicType.CLASSICAL;

    public MusicType getMusicType() {
        return musicType;
    }

    @Override
    public List<String> getSongs() {
        List<String> listMusic = Arrays.asList("Bethoven", "Mozart", "Bah");
        return listMusic;
    }

}
