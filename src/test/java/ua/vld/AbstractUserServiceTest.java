package ua.vld;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.vld.model.Role;
import ua.vld.model.User;
import ua.vld.service.UserService;

import static ua.vld.TestData.USER;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class AbstractUserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void saveUser(){
        User testUser = new User(null,"Andrey","Antonov","380975660000","380445660000","login",
                "password","information","Andrey",null,null, Role.ROLE_USER);
        User user = userService.save(testUser);
        Assert.assertEquals(user.toString(), USER.toString());
    }
}
