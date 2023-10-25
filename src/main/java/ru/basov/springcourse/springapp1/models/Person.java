package ru.basov.springcourse.springapp1.models;

import jakarta.validation.constraints.*;

public class Person {

    private int person_id;

    @NotEmpty(message="Field do not empty")
    @Size(min=2, max=20, message="Value should be has from 2 to 20")
    private String name;

    @Min(value=1900, message="Invalid value")
    private int year_of_birth;


    public Person(int person_id, String name, int year_of_birth) {
        this.person_id = person_id;
        this.name = name;
        this.year_of_birth = year_of_birth;

    }

    public Person() {
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear_of_birth() {
        return year_of_birth;
    }

    public void setYear_of_birth(int year_of_birth) {
        this.year_of_birth = year_of_birth;
    }
}
