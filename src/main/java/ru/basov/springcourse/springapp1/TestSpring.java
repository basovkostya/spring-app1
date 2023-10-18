package ru.basov.springcourse.springapp1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


        Computer computer = context.getBean("computer", Computer.class);
        System.out.println(computer);
        //Music rockMusic= context.getBean("rockMusic", Music.class);
        //Music classicalMusic= context.getBean("classicalMusic", Music.class);
        //MusicPlayer musicPlayer = new MusicPlayer(rockMusic);
        //MusicPlayer musicPlayer2 = new MusicPlayer(classicalMusic);









        context.close();
    }
}
