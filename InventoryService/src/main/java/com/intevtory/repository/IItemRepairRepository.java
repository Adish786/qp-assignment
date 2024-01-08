package com.intevtory.repository;

import com.intevtory.model.ItemRepair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemRepairRepository extends JpaRepository<ItemRepair, Long> {

}
