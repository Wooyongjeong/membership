package com.kakaopay.membership.domain.member;

import com.kakaopay.membership.domain.member.dto.MemberBarcodeRequestDto;
import com.kakaopay.membership.domain.member.dto.MemberBarcodeResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MemberBarcodeApi {

    private final MemberService memberService;

    /**
     * 1) 통합 바코드 발급 API
     *
     * @param requestDto 멤버 아이디(memberId)
     * @return 발급된 멤버십 바코드
     */
    @PostMapping("/members/barcode")
    public ResponseEntity<MemberBarcodeResponseDto> barcode(@RequestBody MemberBarcodeRequestDto requestDto) {
        Long memberId = requestDto.getMemberId();
        MemberBarcodeResponseDto memberBarcodeResponseDto = memberService.getMemberBarcode(memberId);
        return ResponseEntity.ok(memberBarcodeResponseDto);
    }

}
