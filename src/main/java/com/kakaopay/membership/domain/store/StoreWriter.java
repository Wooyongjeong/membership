package com.kakaopay.membership.domain.store;

import com.kakaopay.membership.domain.common.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class StoreWriter {

    private final StoreRepository storeRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Store write(String name, Category category) {
        Store store = Store.create(name, category);
        return storeRepository.save(store);
    }

}
