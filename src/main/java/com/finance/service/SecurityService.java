package com.finance.service;


public interface SecurityService {

    String findLoggedInUsername();
    void autoLogin(String phonenumber, String password);
}
