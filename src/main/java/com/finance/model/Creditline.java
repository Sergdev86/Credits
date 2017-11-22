package com.finance.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "creditlines")
public class Creditline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private BigDecimal amount;
    private BigDecimal percents;
    private Date startCredit;
    private Date endCredit;
    private int termInDays;
    private boolean state;
    @ManyToMany(mappedBy = "creditlines")
    private List<Client> clients;

    public Creditline() {
    }

    public Creditline(String name, String description, BigDecimal percents) {
        this.name = name;
        this.description = description;
        this.percents = percents;
    }

    public Creditline(String name, String description, BigDecimal amount, BigDecimal percents, Date startCredit,
                      Date endCredit, int termInDays, boolean state) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.percents = percents;
        this.startCredit = startCredit;
        this.endCredit = endCredit;
        this.termInDays = termInDays;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getPercents() {
        return percents;
    }

    public void setPercents(BigDecimal percents) {
        this.percents = percents;
    }

    public Date getStartCredit() {
        return startCredit;
    }

    public void setStartCredit(Date startCredit) {
        this.startCredit = startCredit;
    }

    public Date getEndCredit() {
        return endCredit;
    }

    public void setEndCredit(Date endCredit) {
        this.endCredit = endCredit;
    }

    public int getTermInDays() {
        return termInDays;
    }

    public void setTermInDays(int termInDays) {
        this.termInDays = termInDays;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Creditline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", percents=" + percents +
                ", startCredit=" + startCredit +
                ", endCredit=" + endCredit +
                ", termInDays=" + termInDays +
                ", state=" + state +
                ", clients=" + clients +
                '}';
    }
}
