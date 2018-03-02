package com.itheima.e_jdbcdaosupport;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.itheima.a_domain.User;

public class UserDao extends JdbcDaoSupport {

    public void update(User user) {
        String sql = "update t_user set username=?,password=? where id =?";
        Object[] args = {user.getUsername(), user.getPassword(), user.getId()};
        this.getJdbcTemplate().update(sql, args);
    }

    /**
     * 查询所有
     *
     * @return
     */
    public List<User> findAll() {
        return this.getJdbcTemplate().query("select * from t_user", ParameterizedBeanPropertyRowMapper.newInstance(User.class));
    }

}
