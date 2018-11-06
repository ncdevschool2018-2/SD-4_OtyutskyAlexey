package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {
}
