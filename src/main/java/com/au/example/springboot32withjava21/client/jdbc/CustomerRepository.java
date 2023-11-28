package com.au.example.springboot32withjava21.client.jdbc;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {

    private final JdbcClient jdbcClient;

    private final RowMapper<Customer> rowMapper = (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("name"));

    public CustomerRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }


    public List<Customer> list() {
        return jdbcClient.sql("select * from customer order by id")
                .query(rowMapper).list();
    }
}

