package ua.vld.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "phone_book")
public class PhoneBook extends NamedEntity {

    @JsonIgnore
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    public PhoneBook(){
    }

    public PhoneBook(Integer id, String name, String surname, String mobilePhone, String homePhone) {
        super(id, name, surname, mobilePhone, homePhone);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", homePhone='" + homePhone + '\'' +
                '}';
    }
}
