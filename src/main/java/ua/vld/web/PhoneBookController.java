package ua.vld.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.vld.LoggedUser;
import ua.vld.model.PhoneBook;
import ua.vld.service.PhoneBookService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/ajax/phonebook")
public class PhoneBookController {
    @Autowired
    private PhoneBookService phoneBookService;

    @GetMapping
    public List<PhoneBook> getAll(){
        return phoneBookService.getAll(LoggedUser.id());
    }

    @GetMapping(value = "/{id}")
    public PhoneBook get(@PathVariable("id") int id){
        return phoneBookService.get(id,LoggedUser.id());
    }

    @PostMapping
    public void updateOrCreate(@Valid PhoneBook phoneBook){
        phoneBookService.save(phoneBook, LoggedUser.id());
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") int id){
        phoneBookService.delete(id,LoggedUser.id());
    }
}
