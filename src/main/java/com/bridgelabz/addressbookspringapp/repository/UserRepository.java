package com.bridgelabz.addressbookspringapp.repository;

import com.bridgelabz.addressbookspringapp.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserData, Integer> {

    @Query(value = "select * from user_data where user_name = :userName and password = :password", nativeQuery = true)
    Optional<UserData> checkLogin(String userName, String password);
}