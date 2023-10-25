package ru.basov.springcourse.springapp1.models;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

public class Book {
    private int id;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Size(min=2, max=100, message="Допустимое кол-во символов от 2 до 100")
    private String title;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Size(min=2, max=100, message="Допустимое кол-во символов от 2 до 100")
    private String author;

    @Min(value = 1600, message = "Минимальная дата должна быть 1600")
    private int year;

    public Book( String title, String author, int year) {
        this.title = title;
        this.author = author;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
