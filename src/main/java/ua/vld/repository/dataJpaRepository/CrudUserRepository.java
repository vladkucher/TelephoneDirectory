package ua.vld.repository.dataJpaRepository;


import org.springframework.data.repository.CrudRepository;
import ua.vld.model.User;

public interface CrudUserRepository extends CrudRepository<User,Integer> {
    User findByLogin(String login);
}
