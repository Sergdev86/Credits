package com.finance.repository;

import com.finance.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientDAO extends CrudRepository<Client, Long> {
    Client findByLastname(String lastname);
    Client saveAndFlush(Client client);
    Client findByPhonenumber(String phonenumber);
}
