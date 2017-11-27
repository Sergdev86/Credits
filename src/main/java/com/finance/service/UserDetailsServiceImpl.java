package com.finance.service;

import com.finance.model.Client;
import com.finance.model.Role;
import com.finance.repository.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private ClientDAO clientDAO;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Client client = clientDAO.findByLogin(login);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();

        for(Role role: client.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(client.getLogin(), client.getPassword(), grantedAuthorities);
    }
}
