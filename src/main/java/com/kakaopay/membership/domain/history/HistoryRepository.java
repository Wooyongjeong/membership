package com.kakaopay.membership.domain.history;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long>, HistoryRepositoryCustom {
}
