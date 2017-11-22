package com.finance.model;

import javax.persistence.*;

@Entity
@Table(name ="phonenumbers")
public class Phonenumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "phonenumber")
    private String phonenumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Phonenumber{" +
                "id=" + id +
                ", phonenumber='" + phonenumber + '\'' +
                ", client=" + client +
                '}';
    }
}
