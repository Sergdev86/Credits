package com.finance.service;

import com.finance.model.Client;
import com.finance.model.Role;
import com.finance.repository.ClientDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


public class UserDetailsServiceImpl implements UserDetailsService{

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Autowired
    private ClientDAO clientDAO;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String phonenumber) throws UsernameNotFoundException {
        Client client = clientDAO.findByPhonenumber(phonenumber);
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();


        for(Role role: client.getRoles()){

            roles.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new User(client.getPhonenumber(), client.getPassword(), roles);
    }
}
