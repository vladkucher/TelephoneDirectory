package ua.vld.repository.jsonRepository;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ua.vld.model.BaseEntity;
import ua.vld.model.User;
import ua.vld.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;

import static ua.vld.util.JsonRepositoryUtil.getFromFile;
import static ua.vld.util.JsonRepositoryUtil.writeToFile;

@Repository
@Profile({"jsondata", "default"})
public class JsonUserRepository implements UserRepository{
    @Autowired
    private Gson gson= new Gson();

    @Value("${file.name}")
    private String fileName="D:\\file.json";

    @Override
    public User save(User user){
        List<User> userList = getFromFile(gson,fileName);
        int maxId;
        if(userList==null){
            userList=new ArrayList<>();
            maxId=0;
        }else {
            maxId = userList.stream()
                    .mapToInt(BaseEntity::getId)
                    .max().orElse(0);
        }
        user.setId(++maxId);
        userList.add(user);
        writeToFile(gson,userList,fileName);
        return user;
    }

    @Override
    public User get(int id){
        return getFromFile(gson,fileName).stream()
                .filter(u->u.getId()==id)
                .findFirst().get();
    }

    @Override
    public User getByLogin(String login){
        List<User> userList = getFromFile(gson,fileName);
        return userList==null ? null :
                userList.stream()
                .filter(u->u.getLogin().equals(login))
                .findFirst().orElse(null);
    }
}
