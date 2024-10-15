package com.davidrotabor.paymentsB.repository;

import com.davidrotabor.paymentsB.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
