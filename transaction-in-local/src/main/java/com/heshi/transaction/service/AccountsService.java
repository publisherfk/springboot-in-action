package com.heshi.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class AccountsService {
    @Autowired
    private Connection connection;

    public void transfer() throws SQLException {
        String plus = "UPDATE t_user SET MONEY= MONEY+1000 where user_name=?";
        String minus = "UPDATE t_user SET MONEY= MONEY-1000 where user_name=?";
        connection.setAutoCommit(false);
        update(plus, "heshi");
        update(minus, "fukun");
        connection.commit();
    }

    public int update(String sql, String userName) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, userName);
        int result = ps.executeUpdate();
        return result;
    }
}
