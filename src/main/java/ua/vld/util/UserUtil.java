package ua.vld.util;

import ua.vld.model.Role;
import ua.vld.model.User;
import ua.vld.to.UserTo;

public class UserUtil {

    public static User createNewFromTo(UserTo newUser) {
        return new User(null, newUser.getName(), newUser.getSurname(), newUser.getMobilePhone(), newUser.getHomePhone(),
                newUser.getLogin(), newUser.getPassword(), newUser.getInfo(), newUser.getPatronymic(), newUser.getEmail(),
                newUser.getAddress(), Role.ROLE_USER);
    }

}
