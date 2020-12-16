package com.itsol.bankapi.services.Impl;

import com.itsol.bankapi.exception.ResourceNotFoundException;
import com.itsol.bankapi.exception.UnauthorizedException;
import com.itsol.bankapi.models.Account;
import com.itsol.bankapi.models.ERole;
import com.itsol.bankapi.payload.response.ApiResponse;
import com.itsol.bankapi.repository.AccountQuerySQL;
import com.itsol.bankapi.repository.AccountRepository;
import com.itsol.bankapi.security.services.UserDetailsImpl;
import com.itsol.bankapi.services.AccountService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.itsol.bankapi.utils.AppConstants.ACCOUNT;
import static com.itsol.bankapi.utils.AppConstants.ID;

/**
 * @author SangLM
 * @Created 11/12/2020 - 11:04 AM
 * @Project spring-boot-security-jwt
 **/
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountQuerySQL accountQuerySQL;

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> getAccount(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account createAccount(Account account, UserDetailsImpl currentUser) {
        return accountRepository.save(account);
    }

    @Override
    public Account editAccount(Long id, Account newAccount, UserDetailsImpl currentUser) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ACCOUNT, ID, id));

        if (account.getId().equals(currentUser.getId())
                || currentUser.getAuthorities().contains((new SimpleGrantedAuthority(ERole.ROLE_ADMIN.toString())))) {
            account.setAccountNumber(newAccount.getAccountNumber());
            account.setLastname(newAccount.getLastname());
            account.setFirstname(newAccount.getFirstname());
            account.setBalance(newAccount.getBalance());
            account.setAge(newAccount.getAge());
            account.setEmail(newAccount.getEmail());
            account.setEmployer(newAccount.getEmployer());
            account.setAddress(newAccount.getAddress());
            account.setCity(newAccount.getCity());
            account.setState(newAccount.getState());
            account.setGender(newAccount.getGender());

            return accountRepository.save(account);
        }

        ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, "You don't have permission to update profile of:" + id);
        throw  new UnauthorizedException(apiResponse);
    }

    @Override
    public void deleteAccount(Long id, UserDetailsImpl currentUser) {
         accountRepository.deleteById(id);
    }

    @Override
    public List<Account> findKey(String find){
        return this.accountQuerySQL.getAccountSQL(find);
    }
}
