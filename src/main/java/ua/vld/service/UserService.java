package ua.vld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.vld.LoggedUser;
import ua.vld.model.User;
import ua.vld.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;


    public User save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User get(int id) {
        return userRepository.get(id);
    }

    public User findByLogin(String login){
        return userRepository.getByLogin(login);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User u = userRepository.getByLogin(s);
        if (u == null) {
            throw new UsernameNotFoundException("User " + s + " is not found");
        }
        return new LoggedUser(u);
    }
}
