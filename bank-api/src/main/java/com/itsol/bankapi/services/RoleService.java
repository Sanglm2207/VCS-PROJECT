package com.itsol.bankapi.services;

import com.itsol.bankapi.models.Role;

import java.util.List;

/**
 * @author SangLM
 * @Created 22/12/2020 - 3:29 PM
 * @Project spring-boot-security-jwt
 **/
public interface RoleService {
    List<Role> getListRoles();

}
