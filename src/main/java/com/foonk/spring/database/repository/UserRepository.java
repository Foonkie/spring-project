package com.foonk.spring.database.repository;


import com.foonk.spring.database.entity.Role;
import com.foonk.spring.database.entity.User;
import com.foonk.spring.database.pool.ConnectionPool;
import com.foonk.spring.dto.PersonalInfo;
import com.foonk.spring.dto.PersonalInfo2;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>,
        FilterUserRepository,
        RevisionRepository<User, Long, Integer>,
        QuerydslPredicateExecutor<User> {

    @Query("select u from User u " +
            "where u.firstname like %:firstname% and u.lastname like %:lastname%")
    List<User> findAllBy(String firstname, String lastname);

    @Query(value = "SELECT u.* FROM users u WHERE u.username = :username",
            nativeQuery = true)
    List<User> findAllByUsername(String username);
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("update User u " +
            "set u.role = :role " +
            "where u.id in (:ids)")
    int updateRole(Role role, Long... ids);

    @EntityGraph(attributePaths = {"company", "company.locales"})
    @Query(value = "select u from User u",
            countQuery = "select count(distinct u.firstname) from User u")
    Page<User> findAllBy(Pageable pageable);

//    <T> List<T> findAllByCompanyId(Integer companyId,Class<T> clazz);
@Query(value = "SELECT firstname, " +
        "lastname, " +
        "birth_date birthDate " +
        "FROM users " +
        "WHERE company_id = :companyId",
        nativeQuery = true)
List<PersonalInfo2> findAllByCompanyId(Integer companyId);
}


