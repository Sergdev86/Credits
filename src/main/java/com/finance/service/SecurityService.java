package com.finance.service;


public interface SecurityService {

    String findLoggedInUsername();
    void autoLogin(String clientName, String password);
}
