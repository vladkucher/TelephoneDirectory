package ua.vld.repository.dataJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ua.vld.model.User;
import ua.vld.repository.UserRepository;

@Repository
@Profile("datajpa")
public class DataJpaUserPhoneBookImpl implements UserRepository{
    @Autowired
    private CrudUserRepository crudUserRepository;

    @Override
    public User save(User user) {
        return crudUserRepository.save(user);
    }

    @Override
    public User get(int id) {
        return crudUserRepository.findOne(id);
    }

    @Override
    public User getByLogin(String login) {
        return crudUserRepository.findByLogin(login);
    }
}
