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
    private String firstname;
    private String lastname;
    private Date birthdate;
    private String email;
    private String password;
    private String phonenumber;

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

    public Client(String firstname, String lastname, Date birthdate, String email, String phonenumber, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthdate = birthdate;
        this.email = email;
        this.phonenumber = phonenumber;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public void addPhonenumber(String phonenumber) {this.phonenumber = phonenumber; }

    public List<Creditline> getCreditlines() {
        return creditlines;
    }

    public void addCreditline(Creditline creditline) {
        creditlines.add(creditline);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPhonenumber() { return phonenumber; }

    public void setPhonenumber(String phonenumber) {this.phonenumber = phonenumber; }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birthdate=" + birthdate +
                ", email='" + email + '\'' +
                ", phonenumber=" + phonenumber +
                ", creditlines=" + creditlines +
                ", roles=" + roles +
                '}';
    }

}
