package ua.vld.model;

import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User extends NamedEntity {

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "info")
    private String info;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    private boolean enabled = true;

    @Column(name = "registered", columnDefinition = "timestamp default now()")
    private Date registered = new Date();

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<PhoneBook> phoneBooks;

    public User() {
    }

    public User(Integer id, String name, String surname, String mobilePhone, String homePhone, String login,
                String password, String info, String patronymic, String email, String address,
                Role role, Role...roles) {
        this(id,name,surname,mobilePhone,homePhone,login,password,info,patronymic,email,address,true, EnumSet.of(role, roles));
    }

    public User(Integer id, String name, String surname, String mobilePhone, String homePhone, String login,
                String password, String info, String patronymic, String email, String address, boolean enabled,
                 Set<Role> roles) {
        super(id, name, surname, mobilePhone, homePhone);
        this.login = login;
        this.password = password;
        this.info = info;
        this.patronymic = patronymic;
        this.email = email;
        this.address = address;
        this.enabled = enabled;
        this.roles = roles;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = CollectionUtils.isEmpty(roles) ? Collections.emptySet() : EnumSet.copyOf(roles);
    }

    public List<PhoneBook> getPhoneBooks() {
        return phoneBooks;
    }

    public void setPhoneBooks(List<PhoneBook> phoneBooks) {
        this.phoneBooks = phoneBooks;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + getId() + '\'' +
                "name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", surname='" + surname + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", info='" + info + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", enabled=" + enabled +
                ", roles=" + roles +
                ", phoneBooks=" + phoneBooks +
                '}';
    }
}
