package com.kakaopay.membership.domain.store;

import com.kakaopay.membership.domain.common.Category;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long storeId;

    @Column(nullable = false, name = "store_name")
    private String name;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Builder
    private Store(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public static Store create(String name, Category category) {
        return Store.builder()
                .name(name)
                .category(category)
                .build();
    }

}
