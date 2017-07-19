package ua.vld.repository.jsonRepository;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import ua.vld.model.PhoneBook;
import ua.vld.model.User;
import ua.vld.repository.PhoneBookRepository;

import java.util.ArrayList;
import java.util.List;

import static ua.vld.util.JsonRepositoryUtil.getFromFile;
import static ua.vld.util.JsonRepositoryUtil.writeToFile;

@Repository
@Profile({"jsondata", "default"})
public class JsonPhoneBookRepository implements PhoneBookRepository{

    @Autowired
    private Gson gson;

    @Value("${file.name}")
    private String fileName;

    @Override
    public PhoneBook save(PhoneBook phoneBook, int userId){
        List<User> users = getFromFile(gson, fileName);
        User user = users.stream()
                .filter(u->u.getId()==userId)
                .findFirst().get();
        List<PhoneBook> phoneBooks = user.getPhoneBooks();
        if(phoneBooks==null){
            phoneBooks=new ArrayList<>();
            user.setPhoneBooks(phoneBooks);
        }
        if(phoneBook.getId()==null) {
            int maxId = phoneBooks.stream()
                    .mapToInt(p -> p.getId())
                    .max().orElse(0);
            phoneBook.setId(++maxId);
        }else {
            phoneBooks.removeIf(p->p.getId()==phoneBook.getId());
        }
        phoneBooks.add(phoneBook);
        writeToFile(gson,users,fileName);
        return phoneBook;
    }

    @Override
    public PhoneBook get(int id, int userId){
        User user=getFromFile(gson, fileName).stream()
                .filter(u->u.getId()==userId)
                .findFirst().get();

        return user.getPhoneBooks()!=null ?
                user.getPhoneBooks().stream()
                .filter(p->p.getId()==id)
                .findFirst().get()
                : null;
    }

    @Override
    public void delete(int id, int userId){
        List<User> users = getFromFile(gson, fileName);
        User user = users.stream()
                .filter(u -> u.getId() == userId)
                .findFirst().get();
        user.getPhoneBooks().removeIf(p->p.getId()==id);
        writeToFile(gson,users,fileName);
    }

    @Override
    public List<PhoneBook> getAll(int userId){
        List<User> users = getFromFile(gson, fileName);
        User user = users.stream()
                .filter(u -> u.getId() == userId)
                .findFirst().get();
        List<PhoneBook> phoneBooks = user.getPhoneBooks();
        if(phoneBooks==null) {
            return new ArrayList<>();
        }else {
            return phoneBooks;
        }
    }

}
