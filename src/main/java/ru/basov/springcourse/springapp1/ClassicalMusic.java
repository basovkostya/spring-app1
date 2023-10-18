package ru.basov.springcourse.springapp1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component("classicalMusic")

public class ClassicalMusic implements Music{
    @PostConstruct
    public void doMyInit() {
        System.out.println("Do my init");
    }
    @PreDestroy
    public void doMyDestroy(){
            System.out.println("Do my destroy");
        }

    @Override
    public String getSong() {
        return "Bah";
    }

}
