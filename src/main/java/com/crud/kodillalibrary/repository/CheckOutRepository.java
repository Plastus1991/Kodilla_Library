package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.CheckOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckOutRepository extends JpaRepository<CheckOut, Long> {
}
