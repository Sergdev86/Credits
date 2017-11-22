package com.finance.repository;

import com.finance.model.Phonenumber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface PhonenumberDAO extends CrudRepository<Phonenumber, Long> {
}
