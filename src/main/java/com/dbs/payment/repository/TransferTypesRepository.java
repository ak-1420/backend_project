package com.dbs.payment.repository;

import com.dbs.payment.entity.TransferTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferTypesRepository extends JpaRepository<TransferTypes , String> {
}
