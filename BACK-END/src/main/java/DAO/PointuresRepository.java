package DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import ENTITIES.pointures;

public interface PointuresRepository extends JpaRepository<pointures, Integer> {

}
