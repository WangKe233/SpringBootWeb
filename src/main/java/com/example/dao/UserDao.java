package com.example.dao;

import com.example.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by WK on 2018/3/1.
 */

public interface UserDao  extends CrudRepository<User, Long>{

    @Query("from User u where u.username = :username and password = :password")
    User findByUsernameAndPassword(@Param("username") String usernmae, @Param("password") String password);
}
