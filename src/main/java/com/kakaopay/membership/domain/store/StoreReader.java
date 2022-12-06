package com.kakaopay.membership.domain.store;

import com.kakaopay.membership.exception.NoSuchStoreException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class StoreReader {

    private final StoreRepository storeRepository;

    @Transactional(readOnly = true)
    public Store read(Long storeId) {
        return storeRepository.findById(storeId)
                .orElseThrow(NoSuchStoreException::new);
    }

}
