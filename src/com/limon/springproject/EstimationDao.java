package com.limon.springproject;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.BorderLayout;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;
import javax.sql.DataSource;
import javax.swing.*;
import javax.swing.*;
import javax.swing.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class EstimationDao {

    DataSource dataSource;
    JdbcTemplate jdbcTemplet;

    public DataSource getDatasource() {
        return dataSource;
    }

    @Autowired
    public void setDatasource(DataSource dataSource) {
        jdbcTemplet = new JdbcTemplate(dataSource);
    }

    public int userEstimation(Estimation estimation) {
        String sql = "insert into estimate_details(date,month,cost,cost_details,earn,earn_details,deposit,deposit_details,p_id) values('" + estimation.getDate() + "','" + estimation.getMonth() + "','" + estimation.getCost() + "','" + estimation.getCostDetails() + "','" + estimation.getEarn() + "','" + estimation.getEarnDetails() + "','" + estimation.getDeposit() + "','" + estimation.getDepositDetails() + "','" + estimation.getId() + "')";
        //  String sql = "insert into estimate_details(id,date,month,cost,cost_details,earn,earn_details,deposit,deposit_details) values('" + estimation.getId()+ "','" + estimation.getDate() + "','" + estimation.getMonth() + "','" + estimation.getCost() + "','" + estimation.getCostDetails() + "','" + estimation.getEarn() + "','" + estimation.getEarnDetails() + "','" + estimation.getDeposit() + "','" + estimation.getDepositDetails()+ "')";
        int i = jdbcTemplet.update(sql);
        return i;
    }

    public Estimation getExpenditure(int p_id, String month) {
        Estimation ob = new Estimation();
        //  String sql = "select sum(cost) As t_cost,sum(earn) As t_earn,sum(deposit) as t_deposit from estimate_details where p_id=? and month=?";
        String sql = "select sum(cost),sum(earn),sum(deposit) from estimate_details where p_id='" + p_id + "' and month='" + month + "'";
        jdbcTemplet.queryForObject(sql, new Object[]{p_id, month}, new CostEstimationMapper());
        return ob;
    }
    private static class CostEstimationMapper implements RowMapper<Estimation> {
        @Override
        public Estimation mapRow(ResultSet rs, int i) throws SQLException {

            Estimation ob = new Estimation();

            ob.setMonth(rs.getString("month"));
            ob.setCost(rs.getString("cost"));
            ob.setEarn(rs.getString("earn"));
            return ob;

        }

    }

}
