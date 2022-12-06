package com.kakaopay.membership.domain.history;

import com.kakaopay.membership.domain.common.BaseTimeEntity;
import com.kakaopay.membership.domain.member.Member;
import com.kakaopay.membership.domain.store.Store;
import com.kakaopay.membership.domain.common.Category;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class History extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long historyId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Enumerated(value = EnumType.STRING)
    private HistoryType type;

    private Integer amount;

    @Builder
    private History(Member member, Store store, Category category, HistoryType type, Integer amount) {
        this.member = member;
        this.store = store;
        this.category = category;
        this.type = type;
        this.amount = amount;
    }

    public static History create(Member member, Store store, Category category, HistoryType type, Integer amount) {
        return History.builder()
                .member(member)
                .store(store)
                .category(category)
                .type(type)
                .amount(amount)
                .build();
    }
}
