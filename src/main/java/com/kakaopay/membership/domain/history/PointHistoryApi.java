package com.kakaopay.membership.domain.history;

import com.kakaopay.membership.domain.history.dto.MemberHistoryResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
public class PointHistoryApi {

    private final HistoryService historyService;

    /**
     * 4) 내역 조회 API
     *
     * @param startAt 시작기간
     * @param endAt   종료기간
     * @param barcode 멤버십 바코드
     * @return @return 멤버십 바코드의 내역
     */
    @GetMapping("/members/history")
    public ResponseEntity<MemberHistoryResponseDto> history(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startAt,
                                                            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime endAt,
                                                            @RequestParam String barcode) {
        MemberHistoryResponseDto historyResponseDto = historyService.search(startAt, endAt, barcode);
        return ResponseEntity.ok(historyResponseDto);
    }
}
