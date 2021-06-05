package com.a2r.restfulws.repository;

import com.a2r.restfulws.model.Banque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Banque,Long> {}