package com.finance.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private Date birthdate;
    private String email;
    private String login;
    private String password;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Phonenumber> phonenumbers;
    @ManyToMany
    @JoinTable(name = "clients_creditlines",
            joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "creditline_id", referencedColumnName = "id"))
    private List<Creditline> creditlines;
    @ManyToMany
    @JoinTable(name = "clients_roles",
            joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles;

    public Client() {
    }

    public Client(String firstName, String lastName, Date birthdate, String email, String login, List<Phonenumber> phonenumbers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.email = email;
        this.login = login;
        this.phonenumbers = phonenumbers;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Phonenumber> getPhonenumbers() {
        return phonenumbers;
    }

    public void addPhonenumber(Phonenumber phonenumber) {
        phonenumbers.add(phonenumber);
    }

    public List<Creditline> getCreditlines() {
        return creditlines;
    }

    public void addCreditline(Creditline creditline) {
        creditlines.add(creditline);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhonenumbers(List<Phonenumber> phonenumbers) {
        this.phonenumbers = phonenumbers;
    }

    public void setCreditlines(List<Creditline> creditlines) {
        this.creditlines = creditlines;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", phonenumbers=" + phonenumbers +
                ", creditlines=" + creditlines +
                ", roles=" + roles +
                '}';
    }

}
