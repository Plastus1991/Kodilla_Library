package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {

    Optional<Reader> findById(Long id);
}
