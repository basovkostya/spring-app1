package ru.basov.springcourse.springapp1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class MusicPlayer {
    List<Music> musicList = new ArrayList<>();

    private String name;
    private int volume;
    private Music music1;
    private Music music2;
    @Autowired
    public MusicPlayer(@Qualifier("classicalMusic")Music music1,@Qualifier("rockMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void playMusic(MusicType musicType){
        Random random = new Random();
        int randomNumber  = random.nextInt(3);

        if (musicType == MusicType.CLASSICAL){
            System.out.println(music1.getSongs().get(randomNumber));
        }
        else {
            System.out.println(music2.getSongs().get(randomNumber));
        }

    }
}
