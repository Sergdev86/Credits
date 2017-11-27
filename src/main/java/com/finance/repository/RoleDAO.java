package com.finance.repository;

import com.finance.model.Role;
import javafx.scene.effect.SepiaTone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;


public interface RoleDAO extends CrudRepository<Role, Long>{
}
