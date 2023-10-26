package ru.basov.springcourse.springapp1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.basov.springcourse.springapp1.models.Book;
import ru.basov.springcourse.springapp1.models.Person;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {
private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }

    public List<Book> index(){
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }
    public void save(Book book){
        jdbcTemplate.update("INSERT INTO Book(title, author, year) VALUES(?, ?, ?)",
                book.getTitle(), book.getAuthor(), book.getYear());
    }
    public void update(int id, Book book){
        jdbcTemplate.update("UPDATE Book SET title=?, author=?, year=? WHERE id=?",
                book.getTitle(), book.getAuthor(), book.getYear(), id);
    }
    public void selectPerson(int id, Person person){
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE id=?",
                person.getId(), id);
    }
    public void release(int id){
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE id=?",
                null, id);
    }
    public Optional<Person> getPerson(int id) {
        return jdbcTemplate.query("SELECT Person.* FROM Book JOIN Person ON Book.person_id = Person.id " +
                "WHERE Book.id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny();
    }
    public Book show(int id){
        return jdbcTemplate.query("SELECT * From Book WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }
    public void delete(int id){

        jdbcTemplate.update("DELETE FROM Book WHERE id=?", id);
    }
}
