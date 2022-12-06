package com.kakaopay.membership;

import com.kakaopay.membership.domain.member.MemberWriter;
import com.kakaopay.membership.domain.common.Category;
import com.kakaopay.membership.domain.store.StoreWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Component
public class TestDataInitializer {

    private final MemberWriter memberWriter;
    private final StoreWriter storeWriter;

    @PostConstruct
    public void init() {
        memberWriter.write(123456789L);
        memberWriter.write(111111111L);
        memberWriter.write(987654321L);
        memberWriter.write(100000000L);

        for (int i = 1; i <= 10; i++) {
            storeWriter.write("식품" + i, Category.A);
            storeWriter.write("화장품" + i, Category.B);
            storeWriter.write("식당" + i, Category.C);
        }

    }

}
