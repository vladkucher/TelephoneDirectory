package ua.vld.repository.dataJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ua.vld.model.PhoneBook;
import ua.vld.repository.PhoneBookRepository;

import java.util.List;

@Repository
@Profile("datajpa")
public class DataJpaPhoneBookRepositoryImpl implements PhoneBookRepository{
    @Autowired
    private CrudPhoneBookRepository crudPhoneBookRepository;

    @Autowired
    private CrudUserRepository crudUserRepository;

    @Override
    public PhoneBook save(PhoneBook phoneBook, int userId) {
        phoneBook.setUser(crudUserRepository.findOne(userId));
        return crudPhoneBookRepository.save(phoneBook);
    }

    @Override
    public PhoneBook get(int id, int userId) {
        return crudPhoneBookRepository.findOne(id);
    }

    @Override
    public void delete(int id, int userId) {
        crudPhoneBookRepository.delete(id);
    }

    @Override
    public List<PhoneBook> getAll(int userId) {
        return crudPhoneBookRepository.findByUser_Id(userId);
    }
}
