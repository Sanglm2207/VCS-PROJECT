package com.itsol.bankapi.repository;

import com.itsol.bankapi.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author SangLM
 * @Created 16/12/2020 - 10:35 AM
 * @Project spring-boot-security-jwt
 **/
@Repository
public class AccountQuerySQL extends JdbcDaoSupport {
    @Autowired
    public void ReturnListDAO(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    public List<Account> getAccountSQL(String sql) {
        List<Account> ls = this.getJdbcTemplate().query(sql, new BeanPropertyRowMapper<>(Account.class));
        return  ls;
    }
}
