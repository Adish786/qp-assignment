package com.intevtory.repository;

import com.intevtory.model.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemTypeRepository extends JpaRepository<ItemType, Long> {

}