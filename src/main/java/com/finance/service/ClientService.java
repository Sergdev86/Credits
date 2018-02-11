package com.finance.service;

import com.finance.model.Client;
import com.finance.model.Creditline;

import java.util.List;


public interface ClientService {

    Client createClient(Client client);
    void deleteClient(Long id);
    void updateClient(Client client);
    void openNewCreditline(Client client, Creditline creditline);
    Client findClientByLastname(String lastName);
    List<Client> getAllClients();
    Client findClientByPhonenumber(String phonenumber);
}
