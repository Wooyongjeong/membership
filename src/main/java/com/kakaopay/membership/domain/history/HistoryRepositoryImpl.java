package com.kakaopay.membership.domain.history;

import com.kakaopay.membership.domain.history.dto.HistoryDto;
import com.kakaopay.membership.domain.history.dto.QHistoryDto;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

import static com.kakaopay.membership.domain.history.QHistory.history;

public class HistoryRepositoryImpl implements HistoryRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public HistoryRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<HistoryDto> search(LocalDateTime startAt, LocalDateTime endAt, String barcode) {
        return queryFactory
                .select(new QHistoryDto(
                        history.createdAt,
                        history.type,
                        history.store.category.stringValue(),
                        history.store.name
                ))
                .from(history)
                .where(barcodeEq(barcode),
                        startAtGoe(startAt),
                        endAtLoe(endAt))
                .fetch();
    }

    private BooleanExpression barcodeEq(String barcode) {
        return barcode == null ? null : history.member.barcode.eq(barcode);
    }

    private BooleanExpression startAtGoe(LocalDateTime startAt) {
        return startAt == null ? null : history.createdAt.goe(startAt);
    }

    private BooleanExpression endAtLoe(LocalDateTime endAt) {
        return endAt == null ? null : history.createdAt.loe(endAt);
    }
}
