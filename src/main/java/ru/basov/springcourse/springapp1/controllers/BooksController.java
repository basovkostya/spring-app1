package ru.basov.springcourse.springapp1.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.basov.springcourse.springapp1.dao.BookDAO;
import ru.basov.springcourse.springapp1.dao.PersonDAO;
import ru.basov.springcourse.springapp1.models.Book;
import ru.basov.springcourse.springapp1.models.Person;

@Controller
@RequestMapping("/books")
public class BooksController {
    private final PersonDAO personDAO;
    private final BookDAO bookDAO;
    @Autowired
    public BooksController(PersonDAO personDAO, BookDAO bookDAO) {
        this.personDAO = personDAO;
        this.bookDAO = bookDAO;
    }
    @GetMapping()
    public String index(Model model){
        model.addAttribute("books", bookDAO.index());
        return "books/index";
    }
    @GetMapping("/new")
    public String newBook(Model model){
        model.addAttribute("book", new Book());
        return "books/new";
    }
    @PostMapping
    public String create(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult){
            if (bindingResult.hasErrors())
            return "books/new";

        bookDAO.save(book);
        return "redirect:/books";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("book", bookDAO.show(id));
        return "books/show";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model){
        model.addAttribute("book", bookDAO.show(id));
        return "books/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult,
                         @PathVariable("id") int id){
        if (bindingResult.hasErrors())
            return "people/edit";
        bookDAO.update(id, book);
        return "redirect:/books";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        bookDAO.delete(id);
        return "redirect:/books";
    }
}
