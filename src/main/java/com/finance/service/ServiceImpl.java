package com.finance.service;


import com.finance.model.Client;
import com.finance.model.Creditline;
import com.finance.model.Role;
import com.finance.repository.ClientDAO;
import com.finance.repository.CreditlineDAO;
import com.finance.repository.RoleDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ServiceImpl implements ClientService, CreditlineService {

    @Autowired
    private ClientDAO clientDAO;

    @Autowired
    private CreditlineDAO creditlineDAO;
    
    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public Client createClient(Client client) {
        client.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
        Set<Role> roles = new HashSet<Role>();
        roles.add(roleDAO.findOne(2L));
        client.setRoles(roles);
        return clientDAO.saveAndFlush(client);
    }

    public void deleteClient(Long id) { clientDAO.delete(id); }

    public void updateClient(Client client) {
        clientDAO.save(client);
    }

    public Client findClientByLastname(String lastname) {
        return clientDAO.findByLastname(lastname);
    }

    public Client findClientByPhonenumber(String phonenumber) { return clientDAO.findByPhonenumber(phonenumber); }

    public List<Client> getAllClients() {
        return (List) clientDAO.findAll();
    }

    public void openNewCreditline(Client client, Creditline creditline) {
        client.addCreditline(creditline);
    }



    public Creditline createCreditline(Creditline creditline) {
        return creditlineDAO.saveAndFlush(creditline);
    }

    public void deleteCreditline(long id) {
        creditlineDAO.delete(id);
    }

    public Creditline findCreditline(String name) {
        return creditlineDAO.findByName(name);
    }

    public List<Creditline> findAllCreditlines() {
        return (List) creditlineDAO.findAll();
    }


}
