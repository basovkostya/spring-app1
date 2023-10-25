package ru.basov.springcourse.springapp1.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

public class Book {
    private int id;

    private int person_id;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Size(min=2, max=100, message="Допустимое кол-во символов от 2 до 100")
    private String name;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Size(min=2, max=100, message="Допустимое кол-во символов от 2 до 100")
    private String authorName;

    private int year;

    public Book(int id, int person_id, String name, String authorName, int year) {
        this.id = id;
        this.person_id = person_id;
        this.name = name;
        this.authorName = authorName;
        this.year = year;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
