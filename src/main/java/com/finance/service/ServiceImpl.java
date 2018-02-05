package com.finance.service;


import com.finance.model.Client;
import com.finance.model.Creditline;
import com.finance.model.Phonenumber;
import com.finance.model.Role;
import com.finance.repository.ClientDAO;
import com.finance.repository.CreditlineDAO;
import com.finance.repository.PhonenumberDAO;
import com.finance.repository.RoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("serviceImpl")
public class ServiceImpl implements ClientService, CreditlineService, PhonenumberService {

    @Autowired
    private ClientDAO clientDao;

    @Qualifier("creditlineDAO")
    @Autowired
    private CreditlineDAO creditlineDao;
    @Qualifier("phonenumberDAO")
    @Autowired
    private PhonenumberDAO phonenumberDao;
    @Qualifier("roleDAO")
    @Autowired
    private RoleDAO roleDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public Client createClient(Client client) {
        client.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
        Set<Role> roles = new HashSet<Role>();
        roles.add(roleDao.findOne(2L));
        client.setRoles(roles);
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
        Phonenumber phonenumberObj = phonenumberDao.findByPhonenumber(phonenumber);
        return phonenumberObj.getClient();
    }

}
