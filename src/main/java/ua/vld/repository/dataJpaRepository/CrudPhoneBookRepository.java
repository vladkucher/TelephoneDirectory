package ua.vld.repository.dataJpaRepository;

import org.springframework.data.repository.CrudRepository;
import ua.vld.model.PhoneBook;

import java.util.List;

public interface CrudPhoneBookRepository extends CrudRepository<PhoneBook,Integer> {
    List<PhoneBook> findByUser_Id(int userId);
}
