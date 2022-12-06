package com.kakaopay.membership.domain.point;

import com.kakaopay.membership.domain.member.Member;
import com.kakaopay.membership.domain.common.Category;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface PointRepository extends JpaRepository<Point, Long> {
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @EntityGraph(attributePaths = {"member"})
    Optional<Point> findByMemberAndCategory(Member member, Category category);
}
