package ru.basov.springcourse.springapp1.models;

import jakarta.validation.constraints.*;

public class Person {

    private int id;

    @NotEmpty(message="Field do not empty")
    @Size(min=2, max=20, message="Value should be has from 2 to 20")
    private String name;

    @NotEmpty(message = "Field do not empty")
    @Email(message = "No valid email")
    private String email;

    @Min(value=0, message="Invalid value")
    private int age;
    //Страна, Город, Индекс (6 цифр)
    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}", message = "You address should be in this format")
    private String address;

    public Person(int id, String name, int age, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.address = address;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
