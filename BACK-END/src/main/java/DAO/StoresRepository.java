package DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import ENTITIES.stores;


public interface StoresRepository extends JpaRepository<stores, Integer> {

}
