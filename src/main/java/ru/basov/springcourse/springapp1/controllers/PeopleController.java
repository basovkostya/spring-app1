package ru.basov.springcourse.springapp1.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.basov.springcourse.springapp1.dao.PersonDAO;
import ru.basov.springcourse.springapp1.models.Person;
import ru.basov.springcourse.springapp1.util.PersonValidator;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PersonDAO personDAO;
    private final PersonValidator personValidator;
    @Autowired
    public PeopleController(PersonDAO personDAO, PersonValidator personValidator) {
        this.personDAO = personDAO;
        this.personValidator = personValidator;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("people", personDAO.index());
        return "people/index";
    }
    @GetMapping("/{person_id}")
    public String show(@PathVariable("person_id") int person_id, Model model){
        model.addAttribute("person", personDAO.show(person_id));
        return "people/show";
    }
    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("person", new Person());
        return "people/new";
    }
    @PostMapping
    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult){
        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors())
            return "people/new";

       personDAO.save(person);
        return "redirect:/people";
    }
    @GetMapping("/{person_id}/edit")
    public String edit(@PathVariable("person_id") int person_id, Model model){
       model.addAttribute("person", personDAO.show(person_id));
       return "people/edit";
    }
    @PatchMapping("/{person_id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult,
                         @PathVariable("person_id") int person_id){
       // personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors())
            return "people/edit";

        personDAO.update(person_id, person);
        return "redirect:/people";
    }
    @DeleteMapping("/{person_id}")
    public String delete(@PathVariable("person_id") int person_id){
        personDAO.delete(person_id);
        return "redirect:/people";
    }
}
