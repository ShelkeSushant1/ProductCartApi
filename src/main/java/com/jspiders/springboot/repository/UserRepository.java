package com.jspiders.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jspiders.springboot.pojo.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findUserByEmailAndPassword(String email, String password);

	User findUserByMobileAndPassword(long mobile, String password);

}
