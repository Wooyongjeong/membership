package com.kakaopay.membership.domain.store;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    @Override
    @EntityGraph(attributePaths = {"category"})
    Optional<Store> findById(Long storeId);
}
