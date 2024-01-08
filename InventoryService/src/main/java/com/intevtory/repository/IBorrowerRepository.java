package com.intevtory.repository;

import com.intevtory.model.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowerRepository extends JpaRepository<Borrower, Long> {

}
