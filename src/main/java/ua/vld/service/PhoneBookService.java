package ua.vld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.vld.model.PhoneBook;
import ua.vld.model.User;
import ua.vld.repository.PhoneBookRepository;

import java.util.List;

@Service
public class PhoneBookService {
    @Autowired
    private PhoneBookRepository phoneBookRepository;


    public PhoneBook save(PhoneBook phoneBook, int userId) {
        return phoneBookRepository.save(phoneBook, userId);
    }

    public void delete(int id, int userId) {
        phoneBookRepository.delete(id,userId);
    }

    public PhoneBook get(int id, int userId) {
        return phoneBookRepository.get(id, userId);
    }

    public List<PhoneBook> getAll(int userId) {
        return phoneBookRepository.getAll(userId);
    }
}
