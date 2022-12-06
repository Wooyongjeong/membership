package com.kakaopay.membership.domain.point;

import com.kakaopay.membership.domain.member.Member;
import com.kakaopay.membership.domain.common.Category;
import com.kakaopay.membership.exception.NotEnoughPointException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class PointWriter {

    private final PointRepository pointRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Point write(Member member, Category category) {
        Point point = Point.create(member, category);
        return pointRepository.save(point);
    }

    @Transactional
    public void earnPoint(Point point, Integer amount) {
        point.earn(amount);
        pointRepository.save(point);
    }

    @Transactional
    public void usePoint(Point point, Integer amount) {
        if (amount < 0) {
            throw new IllegalArgumentException();
        }

        if (point.getPoints() < amount) {
            throw new NotEnoughPointException();
        }

        point.use(amount);
        pointRepository.save(point);
    }


}
