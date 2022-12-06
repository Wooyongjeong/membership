package com.kakaopay.membership.domain.history;

import com.kakaopay.membership.domain.member.Member;
import com.kakaopay.membership.domain.store.Store;
import com.kakaopay.membership.domain.common.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Component
public class HistoryWriter {

    private final HistoryRepository historyRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public History write(Member member, Store store, Category category, HistoryType type, Integer amount) {
        History history = History.create(member, store, category, type, amount);
        return historyRepository.save(history);
    }

}
