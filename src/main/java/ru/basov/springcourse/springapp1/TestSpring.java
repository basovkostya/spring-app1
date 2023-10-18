package ru.basov.springcourse.springapp1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.playMusic(MusicType.CLASSICAL);
        musicPlayer.playMusic(MusicType.ROCK);


        context.close();
    }
}
