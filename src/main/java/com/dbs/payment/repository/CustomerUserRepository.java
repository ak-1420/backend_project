package com.dbs.payment.repository;

import com.dbs.payment.entity.CustomerUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerUserRepository extends JpaRepository<CustomerUser , Long> {
}
