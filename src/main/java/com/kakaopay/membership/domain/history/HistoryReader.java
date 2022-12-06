package com.kakaopay.membership.domain.history;

import com.kakaopay.membership.domain.history.dto.HistoryDto;
import com.kakaopay.membership.exception.NoSuchBarcodeException;
import com.kakaopay.membership.domain.member.MemberReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Component
public class HistoryReader {

    private final HistoryRepository historyRepository;
    private final MemberReader memberReader;

    @Transactional(readOnly = true)
    public List<HistoryDto> search(LocalDateTime startAt, LocalDateTime endAt, String barcode) {
        if (!memberReader.existsByBarcode(barcode)) {
            throw new NoSuchBarcodeException();
        }
        return historyRepository.search(startAt, endAt, barcode);
    }

}
