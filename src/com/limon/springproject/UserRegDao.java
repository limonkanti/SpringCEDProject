package com.limon.springproject;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class UserRegDao {

    DataSource dataSource;
    JdbcTemplate jdbcTemplet;

    public DataSource getDatasource() {
        return dataSource;
    }

    @Autowired
    public void setDatasource(DataSource dataSource) {
        jdbcTemplet = new JdbcTemplate(dataSource);
    }

    public int userRegistration(UserRegistration user) {
        String sql = "insert into registration1(name,email,userId) values('" + user.getName() + "','" + user.getEmail() + "','" + user.getUserId() + "')";
        int i = jdbcTemplet.update(sql);
        return i;
    }

    public int userLogin1(String password) { 
        String sql = "select password from registration where password=?";
        return jdbcTemplet.queryForObject(sql, new Object[]{password}, Integer.class);
    }

    public UserRegistration userLogin(String name, int userId) {
        UserRegistration ob = new UserRegistration();
        String sql = "select name,userId from registration1 where name=? and userId=?";
        jdbcTemplet.queryForObject(sql, new Object[]{name, userId}, new UserRegistrationMapper());
        return ob;
    }

    private static class UserRegistrationMapper implements RowMapper<UserRegistration> {

        @Override
        public UserRegistration mapRow(ResultSet rs, int i) throws SQLException {
            UserRegistration ob = new UserRegistration();
            ob.setName(rs.getString("name"));
            ob.setUserId(rs.getInt("userId"));
            return ob;

        }

    }

}
