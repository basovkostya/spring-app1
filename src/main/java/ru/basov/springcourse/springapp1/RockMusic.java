package ru.basov.springcourse.springapp1;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component("rockMusic")
public class RockMusic implements Music{

    @Override
    public String getSong() {
        return "Linking Park";
    }
}
