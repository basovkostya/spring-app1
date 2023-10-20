package ru.basov.springcourse.springapp1.dao;

import org.springframework.stereotype.Component;
import org.springframework.web.cors.reactive.PreFlightRequestWebFilter;
import ru.basov.springcourse.springapp1.controllers.PeopleController;
import ru.basov.springcourse.springapp1.models.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;
    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Kostya", "basov04@mail.ru", 33));
        people.add(new Person(++PEOPLE_COUNT, "Anton", "12@12.ru", 25));
        people.add(new Person(++PEOPLE_COUNT, "Misha", "13@13.ru", 15));
        people.add(new Person(++PEOPLE_COUNT, "Sasha", "rroor@gmail.com", 35));
    }
    public List<Person> index(){
        return people;
    }
    public Person show(int id){
        return people.stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }
    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
    public void update(int id, Person person){
        Person personUpdate = show(id);
        personUpdate.setName(person.getName());
        personUpdate.setEmail(person.getEmail());
        personUpdate.setAge(person.getAge());


    }
    public void delete(int id){
        people.removeIf(p -> p.getId() == id);
    }
}
