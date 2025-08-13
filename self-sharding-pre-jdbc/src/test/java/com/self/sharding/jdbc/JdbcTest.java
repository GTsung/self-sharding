package com.self.sharding.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {

    @Test
    public void testJdbc() throws SQLException {
        // dataSource -> sharding会实现这一套东西
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8");
        ds.setUsername("root");
        ds.setPassword("123456");

        DruidPooledConnection connection = ds.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from ccs_loan");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            String loanNbr = resultSet.getString("loan_nbr");
            int term = resultSet.getInt("init_term");
            BigDecimal principal = resultSet.getBigDecimal("init_principal");
            System.out.printf("%s-%s-%s%n", loanNbr, term, principal);
        }
        preparedStatement.close();
        resultSet.close();
        connection.close();
    }

}
