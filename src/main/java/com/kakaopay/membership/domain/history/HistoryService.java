package com.kakaopay.membership.domain.history;

import com.kakaopay.membership.domain.history.dto.HistoryDto;
import com.kakaopay.membership.domain.history.dto.MemberHistoryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class HistoryService {

    private final HistoryReader historyReader;

    public MemberHistoryResponseDto search(LocalDateTime startAt, LocalDateTime endAt, String barcode) {
        List<HistoryDto> history = historyReader.search(startAt, endAt, barcode);
        return MemberHistoryResponseDto.builder().history(history).build();
    }

}
