package com.example.board.repository;

import com.example.board.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void save(User user) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("user_id", user.getUserId());
        params.addValue("password", user.getPassword());
        params.addValue("name", user.getName());
//        if (duplicateUserSave(user)) {
//            namedParameterJdbcTemplate.update("UPDATE USER SET password = :password, name = :name WHERE user_id = :userId",params);
//        }
        namedParameterJdbcTemplate.update("INSERT INTO USERS (user_id, password, name) VALUES (:user_id, :password, :name)",params);
    }

    private boolean duplicateUserSave(User user) {
        return findByUserId(user.getUserId()).isPresent();
    }

    public List<User> findAll(){
        return jdbcTemplate.query("SELECT * FROM USERS", userRowMapper());
    }

    public Optional<User> findByUserId(String userId) {
        List<User> userList = jdbcTemplate.query("SELECT * FROM USERS where user_id=?", userRowMapper(), userId);
        return userList.stream().findAny();
    }

    private RowMapper<User> userRowMapper() {
        return (rs, rowNum) -> {
            long id = rs.getLong("id");
            String userId = rs.getString("user_id");
            String password = rs.getString("password");
            String name = rs.getString("name");
            return new User(id, userId, password, name);
        };
    }

}
