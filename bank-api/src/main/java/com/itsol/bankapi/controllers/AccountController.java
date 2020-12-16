package com.itsol.bankapi.controllers;

import com.itsol.bankapi.models.Account;
import com.itsol.bankapi.security.CurrentUser;
import com.itsol.bankapi.security.UserPrincipal;
import com.itsol.bankapi.security.services.UserDetailsImpl;
import com.itsol.bankapi.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * @author SangLM
 * @Created 11/12/2020 - 11:05 AM
 * @Project spring-boot-security-jwt
 **/
@RestController
@CrossOrigin("*")
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    AccountService accountService;


    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/getAllAccounts")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/getAccount/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public Optional<Account> getAccount(@PathVariable(name = "id") Long id) {
        return accountService.getAccount(id);
    }


    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/createAccount")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public Account createAccount(@Valid @RequestBody Account account, @CurrentUser UserDetailsImpl currentUser) {
        return accountService.createAccount(account, currentUser);
    }

    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    @PutMapping("/editAccount/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Account editAccount(@Valid @RequestBody Account newAccount, @PathVariable(name = "id") Long id,
                                            @CurrentUser UserDetailsImpl currentUser) {
        return accountService.editAccount(id, newAccount, currentUser);
    }

    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping("/deleteAccount/{id}")
    public void deleteAccount(@PathVariable(name = "id") Long id, @CurrentUser UserDetailsImpl currentUser) {
        accountService.deleteAccount(id, currentUser);
    }

    @ResponseBody
    @ResponseStatus(code = HttpStatus.OK)
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    @PostMapping("/getFind")
    public List<Account> getKey(@RequestBody Account accounts){
        String find = "SELECT * FROM account ac where 1 = 1 ";
        if(accounts.getAccountNumber() != 0){
            find += "and account_number = " + accounts.getAccountNumber();
        }
        if(accounts.getAddress() != null){
            find += " and address like '%" + accounts.getAddress() + "%'";
        }
        if(accounts.getAge() != 0){
            find += " and age = " + accounts.getAge();
        }
        if(accounts.getBalance() != 0){
            find += " and balance = " + accounts.getBalance();
        }
        if(accounts.getCity() != null){
            find += " and city like '%" + accounts.getCity() + "%'";
        }
        if(accounts.getEmail() != null){
            find += " and email like '%" + accounts.getEmail()+ "%'";
        }
        if(accounts.getEmployer() != null){
            find += " and employer like '%" + accounts.getEmployer()+ "%'";
        }
        if(accounts.getFirstname() != null){
            find += " and firstname like '%" + accounts.getFirstname()+ "%'";
        }
        if(accounts.getGender() != null){
            find += " and gender like '%" + accounts.getGender()+ "%'";
        }
        if(accounts.getLastname() != null){
            find += " and lastname like '%" + accounts.getLastname()+ "%'";
        }
        return accountService.findKey(find);
    }
}
