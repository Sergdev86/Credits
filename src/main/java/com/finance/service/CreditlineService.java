package com.finance.service;

import com.finance.model.Creditline;

import java.util.List;


public interface CreditlineService {

    Creditline createCreditline(Creditline creditline);
    void deleteCreditline(long id);
    Creditline findCreditline(String name);
    List<Creditline> findAllCreditlines();

}
