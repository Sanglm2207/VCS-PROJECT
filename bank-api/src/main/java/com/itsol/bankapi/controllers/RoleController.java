package com.itsol.bankapi.controllers;


import com.itsol.bankapi.models.Role;
import com.itsol.bankapi.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author SangLM
 * @Created 22/12/2020 - 3:43 PM
 * @Project spring-boot-security-jwt
 **/
@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/getAllRoles")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public List<Role> getAllRoles() {
        return roleService.getListRoles();
    }
}
