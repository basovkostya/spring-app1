package ru.basov.springcourse.springapp1.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.basov.springcourse.springapp1.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PersonDAO {

   private final JdbcTemplate jdbcTemplate;
    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index(){
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }
    public Optional<Person> show(String email){
        return jdbcTemplate.query("SELECT * FROM Person WHERE email = ?", new Object[]{email},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny();
    }
    public Person show(int id){
        return jdbcTemplate.query("SELECT * From Person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }
    public void save(Person savePerson){
        jdbcTemplate.update("INSERT INTO Person(name, age, email, address) VALUES(?, ? ,?, ?)",
                savePerson.getName(), savePerson.getAge(), savePerson.getEmail(), savePerson.getAddress());
    }
    public void update(int id, Person updatePerson){
        jdbcTemplate.update("UPDATE Person SET name=?, age=?, email=? address=? WHERE id=?",
                updatePerson.getName(), updatePerson.getAge(), updatePerson.getEmail(), updatePerson.getAddress(), id);
    }
    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }
    public void testMultipleUpdate(){
        List<Person> people = create1000People();
        long before = System.currentTimeMillis();
        for (Person person: people) {
            jdbcTemplate.update("INSERT INTO Person(name, age, email) VALUES(?, ? ,?)",
                    person.getName(), person.getAge(), person.getEmail());
        }
        long after = System.currentTimeMillis();
        System.out.println("Time: "+(after-before));
    }
    public void testBatchUpdate(){
        List<Person> people = create1000People();
        long before = System.currentTimeMillis();

        jdbcTemplate.batchUpdate("INSERT INTO Person(name, age, email) VALUES(?, ?, ?, ?)", new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {

                ps.setString(1, people.get(i).getName());
                ps.setInt(2, people.get(i).getAge());
                ps.setString(3, people.get(i).getEmail());
                ps.setString(4, people.get(i).getAddress());
            }

            @Override
            public int getBatchSize() {
                return people.size();
            }
        });

        long after = System.currentTimeMillis();
        System.out.println("Time: "+(after-before));
    }
    public List<Person> create1000People(){
        List<Person> people = new ArrayList<>();
        for (int i=0; i<1000; i++){
            people.add(new Person(i, "name"+i, 30, "test"+i+"email@.ru", "some_address"));
        }
        return people;
    }
}
