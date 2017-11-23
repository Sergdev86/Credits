package com.finance.service;

import com.finance.model.Client;
import com.finance.model.Creditline;

import java.util.List;


public interface ClientService {

    Client createClient(Client client);
    void deleteClient(Long id);
    void updateClient(Client client);
    void openNewCreditline(Client client, Creditline creditline);
    Client findClient(String lastName);
    List<Client> getAllClient();
}
