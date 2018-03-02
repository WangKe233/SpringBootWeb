package com.example.dao;

import com.example.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by WK on 2018/3/1.
 */

public interface UserDao  extends CrudRepository<User, Long>{

}
