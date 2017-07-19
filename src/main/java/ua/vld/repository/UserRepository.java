package ua.vld.repository;


import ua.vld.model.User;

public interface UserRepository {
    User save(User user);

    User get(int id);

    User getByLogin(String login);
}
