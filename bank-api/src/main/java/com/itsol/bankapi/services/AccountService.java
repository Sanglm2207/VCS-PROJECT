package com.itsol.bankapi.services;

import com.itsol.bankapi.models.Account;
import com.itsol.bankapi.security.services.UserDetailsImpl;

import java.util.List;
import java.util.Optional;

/**
 * @author SangLM
 * @Created 11/12/2020 - 10:54 AM
 * @Project spring-boot-security-jwt
 **/
public interface AccountService {
    List<Account> getAllAccounts();

    Optional<Account> getAccount(Long id);

    Account createAccount(Account account, UserDetailsImpl currentUser);

    Account editAccount(Long id, Account newAccount, UserDetailsImpl currentUser);

    void deleteAccount(Long id, UserDetailsImpl currentUser);

    List<Account> findKey(String find);
}
