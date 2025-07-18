package DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import ENTITIES.articles;

public interface ArticlesRepository  extends JpaRepository<articles, Integer> {

}
