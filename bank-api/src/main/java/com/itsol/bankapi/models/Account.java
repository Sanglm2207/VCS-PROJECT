package com.itsol.bankapi.models;

import javax.persistence.*;

import lombok.Data;

/**
 * @author SangLM
 * @Created 11/12/2020 - 10:48 AM
 * @Project spring-boot-security-jwt
 **/
@Entity
@Table(name = "account")
@Data
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "account_number")
    private int accountNumber;
    @Column(name = "balance")
    private  int balance;
    @Column(name = "first_name")
    private  String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "age")
    private int age;
    @Column(name = "gender")
    private String gender;
    @Column(name = "address")
    private String address;
    @Column(name = "employer")
    private String employer;
    @Column(name = "email")
    private String email;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", employer='" + employer + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
