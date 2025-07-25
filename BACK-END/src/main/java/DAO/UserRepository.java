package DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ENTITIES.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}

