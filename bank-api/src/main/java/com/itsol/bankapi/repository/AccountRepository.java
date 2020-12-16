package com.itsol.bankapi.repository;

import com.itsol.bankapi.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author SangLM
 * @Created 11/12/2020 - 10:53 AM
 * @Project spring-boot-security-jwt
 **/
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Boolean existsAccountsByEmail(String email);

    @Query(value = "SELECT * FROM account ac where 1 = 1" +
            "  :find ",nativeQuery = true)
    List<Account> getAcountByKey(@Param("find") String find);
}
