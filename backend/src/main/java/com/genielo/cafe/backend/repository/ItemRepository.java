package com.genielo.cafe.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.genielo.cafe.backend.model.Ingredient;
import com.genielo.cafe.backend.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

	List<Item> findByType(String type);

}
