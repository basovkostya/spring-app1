package ru.basov.springcourse.springapp1.models;

import jakarta.validation.constraints.*;

public class Person {

    private int id;

    @NotEmpty(message="Поле не должно быть пустым")
    @Size(min=2, max=20, message="Допустимое кол-во символов должно быть от 2 до 20")
    private String fullName;


    @Min(value=1900, message="Значение должно быть >= 1900")
    private int yearOfBirth;


    public Person(String fullName, int yearOfBirth) {
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}
