package com.intevtory.repository;

import com.intevtory.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVendorRepository extends JpaRepository<Vendor, Long> {

}
