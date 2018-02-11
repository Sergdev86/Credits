package com.finance.repository;

import com.finance.model.Creditline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface CreditlineDAO extends CrudRepository<Creditline, Long> {
    Creditline saveAndFlush(Creditline creditline);
    Creditline findByName(String name);

}
