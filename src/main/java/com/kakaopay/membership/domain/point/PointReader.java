package com.kakaopay.membership.domain.point;

import com.kakaopay.membership.domain.member.Member;
import com.kakaopay.membership.domain.member.MemberReader;
import com.kakaopay.membership.domain.common.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class PointReader {

    private final PointRepository pointRepository;
    private final MemberReader memberReader;
    private final PointWriter pointWriter;

    @Transactional(readOnly = true)
    public Point read(String barcode, Category category) {
        Member member = memberReader.read(barcode);
        return pointRepository.findByMemberAndCategory(member, category)
                .orElseGet(() -> pointWriter.write(member, category));
    }

}
