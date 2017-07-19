package ua.vld.repository;


import ua.vld.model.PhoneBook;

import java.util.List;

public interface PhoneBookRepository {
    PhoneBook save(PhoneBook phoneBook, int userId);

    PhoneBook get(int id, int userId);

    void delete(int id, int userId);

    List<PhoneBook> getAll(int userId);
}
