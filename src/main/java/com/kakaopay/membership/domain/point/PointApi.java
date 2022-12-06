package com.kakaopay.membership.domain.point;

import com.kakaopay.membership.domain.point.dto.PointRequestDto;
import com.kakaopay.membership.domain.point.dto.PointResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PointApi {

    private final PointService pointService;

    @PutMapping("/members/points/earn")
    public ResponseEntity<PointResponseDto> earnPoint(@RequestBody PointRequestDto pointRequestDto) {
        Long storeId = pointRequestDto.getStoreId();
        String barcode = pointRequestDto.getBarcode();
        Integer amount = pointRequestDto.getAmount();

        PointResponseDto responseDto = pointService.earn(storeId, barcode, amount);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/members/points/use")
    public ResponseEntity<PointResponseDto> usePoint(@RequestBody PointRequestDto pointRequestDto) {
        Long storeId = pointRequestDto.getStoreId();
        String barcode = pointRequestDto.getBarcode();
        Integer amount = pointRequestDto.getAmount();

        PointResponseDto responseDto = pointService.use(storeId, barcode, amount);
        return ResponseEntity.ok(responseDto);
    }

}
