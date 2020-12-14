package com.itsol.bankapi.repository;

import com.itsol.bankapi.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author SangLM
 * @Created 11/12/2020 - 10:53 AM
 * @Project spring-boot-security-jwt
 **/
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
