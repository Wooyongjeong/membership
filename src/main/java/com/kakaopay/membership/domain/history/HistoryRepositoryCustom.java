package com.kakaopay.membership.domain.history;

import com.kakaopay.membership.domain.history.dto.HistoryDto;

import java.time.LocalDateTime;
import java.util.List;

public interface HistoryRepositoryCustom {

    List<HistoryDto> search(LocalDateTime startAt, LocalDateTime endAt, String barcode);
}
