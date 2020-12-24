package com.itsol.bankapi.services.Impl;

import com.itsol.bankapi.models.Role;
import com.itsol.bankapi.repository.RoleRepository;
import com.itsol.bankapi.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SangLM
 * @Created 22/12/2020 - 3:31 PM
 * @Project spring-boot-security-jwt
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getListRoles() {
        return roleRepository.findAll();
    }
}
