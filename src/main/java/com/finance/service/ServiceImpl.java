package com.finance.service;


import com.finance.model.Client;
import com.finance.model.Creditline;
import com.finance.model.Phonenumber;
import com.finance.repository.ClientDAO;
import com.finance.repository.CreditlineDAO;
import com.finance.repository.PhonenumberDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServiceImpl implements ClientService, CreditlineService, PhonenumberService {

    @Autowired
    ClientDAO clientDao;
    @Autowired
    CreditlineDAO creditlineDao;
    @Autowired
    PhonenumberDAO phonenumberDAO;

    public Client createClient(Client client) {
        return clientDao.saveAndFlush(client);
    }

    public void deleteClient(Long id) {
        clientDao.delete(id);
    }

    public void updateClient(Client client) {
        clientDao.save(client);
    }

    public void openNewCreditline(Client client, Creditline creditline) {
        client.addCreditline(creditline);
    }

    public Client findClient(String lastName) {
        return clientDao.findByLastName(lastName);
    }

    public List<Client> getAllClient() {
        return (List)clientDao.findAll();
    }

    public Creditline createCreditline(Creditline creditline) {
        return creditlineDao.saveAndFlush(creditline);
    }

    public void deleteCreditline(long id) {
        creditlineDao.delete(id);
    }

    public Creditline findCreditline(String name) {
        return creditlineDao.findByName(name);
    }

    public List<Creditline> findAllCreditlines() {
        return (List)creditlineDao.findAll();
    }

    public Client findClientByPhonenumber(String phonenumber) {
        Phonenumber phonenumberObj = phonenumberDAO.findByPhonenumber(phonenumber);
        return phonenumberObj.getClient();
    }
}
