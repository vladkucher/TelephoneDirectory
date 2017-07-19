package ua.vld.model;


import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class NamedEntity extends BaseEntity {

    @Column(name = "name", nullable = false)
    protected String name;

    @Column(name = "surname", nullable = false)
    protected String surname;

    @Column(name = "mobile_phone")
    protected String mobilePhone;

    @Column(name = "home_phone")
    protected String homePhone;

    public NamedEntity() {
    }

    protected NamedEntity(Integer id, String name, String surname, String mobilePhone, String homePhone) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.mobilePhone = mobilePhone;
        this.homePhone = homePhone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    @Override
    public String toString() {
        return "NamedEntity{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", homePhone='" + homePhone + '\'' +
                '}';
    }
}
