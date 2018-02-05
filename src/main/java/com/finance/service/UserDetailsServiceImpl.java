package com.finance.service;

import com.finance.model.Client;
import com.finance.model.Role;
import com.finance.repository.ClientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private ClientDAO clientDAO;

    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Client client = clientDAO.findByLogin(login);
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();

        for(Role role: client.getRoles()){
            roles.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new User(client.getLogin(), client.getPassword(), roles);
    }
}
