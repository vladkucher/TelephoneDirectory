package ua.vld.to;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class UserTo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "*Please provide a login")
    @Pattern(regexp = "^[A-Za-z0-9]*$", message = "*Your login must have only english characters")
    @Length(min = 3, message = "*Your login must have at least 3 characters")
    private String login;

    @Length(min = 5, message = "*Your password must have at least 5 characters")
    private String password;

    @NotEmpty(message = "*Please provide an info")
    @Length(min = 5, message = "*Your info must have at least 5 characters")
    private String info;

    @NotEmpty(message = "*Please provide an name")
    @Length(min = 4, message = "*Your name must have at least 4 characters")
    private String name;

    @NotEmpty(message = "*Please provide an surname")
    @Length(min = 4, message = "*Your surname must have at least 4 characters")
    private String surname;

    @NotEmpty(message = "*Please provide a patronymic")
    @Length(min = 4, message = "*Your patronymic must have at least 4 characters")
    private String patronymic;

    @NotEmpty(message = "*Please provide an mobile phone")
    @Pattern(regexp="^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$", message = "*Enter the correct number")
    private String mobilePhone;

    @Pattern(regexp="^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$", message = "*Enter the correct number")
    private String homePhone;

    @Email
    private String email;

    private String address;

    public UserTo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
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

    @Override
    public String toString() {
        return "UserTo{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", info='" + info + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

