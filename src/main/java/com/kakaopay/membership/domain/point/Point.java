package com.kakaopay.membership.domain.point;

import com.kakaopay.membership.domain.common.BaseTimeEntity;
import com.kakaopay.membership.domain.member.Member;
import com.kakaopay.membership.domain.common.Category;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Point extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pointId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    private Integer points;

    @Version
    private Integer version;

    @Builder
    private Point(Member member, Category category) {
        this.member = member;
        this.category = category;
        this.points = 0;
    }

    public static Point create(Member member, Category category) {
        return Point.builder()
                .member(member)
                .category(category)
                .build();
    }

    public void earn(Integer amount) {
        this.points += amount;
    }

    public void use(Integer amount) {
        this.points -= amount;
    }

}
