package com.finance.service;

import com.finance.model.Client;
import com.finance.model.Phonenumber;

public interface PhonenumberService {

    Client findClientByPhonenumber(String phonenumber);
}
