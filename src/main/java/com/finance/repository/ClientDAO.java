package com.finance.repository;

import com.finance.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ClientDAO extends CrudRepository<Client, Long> {
    Client findByLastName(String lastName);
    Client saveAndFlush(Client client);
    Client findByLogin(String login);

}
