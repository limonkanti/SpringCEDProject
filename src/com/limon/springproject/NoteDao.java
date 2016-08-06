
package com.limon.springproject;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class NoteDao {

    DataSource dataSource;
    JdbcTemplate jdbcTemplet;

    public DataSource getDatasource() {
        return dataSource;
    }

    @Autowired
    public void setDatasource(DataSource dataSource) {
        jdbcTemplet = new JdbcTemplate(dataSource);
    }

    public int userNote(Note note) {
        String sql = "insert into notes(p_id,date,month,note) values('" + note.getId() + "','" +note.getDate()+ "','" + note.getMonth() + "','" + note.getNote() + "')";
        //  String sql = "insert into estimate_details(id,date,month,cost,cost_details,earn,earn_details,deposit,deposit_details) values('" + estimation.getId()+ "','" + estimation.getDate() + "','" + estimation.getMonth() + "','" + estimation.getCost() + "','" + estimation.getCostDetails() + "','" + estimation.getEarn() + "','" + estimation.getEarnDetails() + "','" + estimation.getDeposit() + "','" + estimation.getDepositDetails()+ "')";
        int i = jdbcTemplet.update(sql);
        return i;
    }



}

