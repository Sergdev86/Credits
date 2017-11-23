package com.finance.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Phonenumber> phonenumbers;
    @ManyToMany
    @JoinTable(name = "clients_creditlines",
            joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "creditline_id", referencedColumnName = "id"))
    private List<Creditline> creditlines;

    public Client() {
    }

    public Client(String firstName, String lastName, Date birthdate, String email, List<Phonenumber> phonenumbers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.email = email;
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

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                ", email='" + email + '\'' +
                ", phonenumbers=" + phonenumbers +
                ", creditlines=" + creditlines +
                '}';
    }
}
