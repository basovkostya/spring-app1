package ru.basov.springcourse.springapp1.dao;

import org.springframework.stereotype.Component;
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
        people.add(new Person(++PEOPLE_COUNT, "Kostya"));
        people.add(new Person(++PEOPLE_COUNT, "Anton"));
        people.add(new Person(++PEOPLE_COUNT, "Misha"));
        people.add(new Person(++PEOPLE_COUNT, "Sasha"));
    }
    public List<Person> index(){
        return people;
    }
    public Person show(int id){
        return people.stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }
}
