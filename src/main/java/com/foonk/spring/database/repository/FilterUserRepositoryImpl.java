package com.foonk.spring.database.repository;

import com.foonk.spring.database.entity.User;
import com.foonk.spring.dto.UserFilter;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class FilterUserRepositoryImpl implements FilterUserRepository {

    private final EntityManager entityManager;

    @Override
    public List<User> findAllByFilter(UserFilter filter) {
        var cb = entityManager.getCriteriaBuilder();
        var criteria = cb.createQuery(User.class);

        var user = criteria.from(User.class);
        criteria.select(user);

        List<Predicate> predicates = new ArrayList<>();
        if (filter.getFirstname() != null) {
            predicates.add(cb.like(user.get("firstname"), filter.getFirstname()));
        }
        if (filter.getLastname() != null) {
            predicates.add(cb.like(user.get("lastname"), filter.getLastname()));
        }
        if (filter.getBirthDate() != null) {
            predicates.add(cb.lessThan(user.get("birthDate"), filter.getBirthDate()));
        }
        criteria.where(predicates.toArray(Predicate[]::new));

        return entityManager.createQuery(criteria).getResultList();
    }
}