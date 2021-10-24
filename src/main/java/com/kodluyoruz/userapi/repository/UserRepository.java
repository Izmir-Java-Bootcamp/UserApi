package com.kodluyoruz.userapi.repository;


import com.kodluyoruz.userapi.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "update #{#entityName} u set u.registeredBookCount= u.registeredBookCount+1 where u.id= :id")
    @Modifying(clearAutomatically = true)
    int incrementRegisteredBookCount(@Param("id") Integer id);
}
