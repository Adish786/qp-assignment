package com.intevtory.repository;

import com.intevtory.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IItemIssuanceRepository extends JpaRepository<Loan, Long> {

}
