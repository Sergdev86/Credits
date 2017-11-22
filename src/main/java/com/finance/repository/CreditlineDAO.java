package com.finance.repository;

import com.finance.model.Creditline;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface CreditlineDAO extends CrudRepository<Creditline, Long> {
}
