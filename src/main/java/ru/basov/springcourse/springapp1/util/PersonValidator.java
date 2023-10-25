package ru.basov.springcourse.springapp1.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.basov.springcourse.springapp1.dao.PersonDAO;
import ru.basov.springcourse.springapp1.models.Person;
@Component
public class PersonValidator implements Validator {
    private final PersonDAO personDAO;
    @Autowired
    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;
        if(personDAO.show(person.getFullName()).isPresent())
            errors.rejectValue("fullName", "", "Имя должно быть уникальным");
    }
    //посмотреть , есть ли человек с таким же имейлом в БД
}
