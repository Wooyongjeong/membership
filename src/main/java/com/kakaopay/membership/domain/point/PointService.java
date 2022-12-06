package com.kakaopay.membership.domain.point;

import com.kakaopay.membership.domain.history.HistoryType;
import com.kakaopay.membership.domain.history.HistoryWriter;
import com.kakaopay.membership.domain.point.dto.PointResponseDto;
import com.kakaopay.membership.domain.store.Store;
import com.kakaopay.membership.domain.store.StoreReader;
import com.kakaopay.membership.domain.common.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PointService {

    private final PointReader pointReader;
    private final PointWriter pointWriter;
    private final StoreReader storeReader;
    private final HistoryWriter historyWriter;

    public PointResponseDto earn(Long storeId, String barcode, Integer amount) {
        Store store = storeReader.read(storeId);
        Category category = store.getCategory();

        Point point = pointReader.read(barcode, category);
        pointWriter.earnPoint(point, amount);

        historyWriter.write(point.getMember(), store, category, HistoryType.EARN, amount);

        return new PointResponseDto(barcode, category, point.getPoints());
    }

    public PointResponseDto use(Long storeId, String barcode, Integer amount) {
        Store store = storeReader.read(storeId);
        Category category = store.getCategory();

        Point point = pointReader.read(barcode, category);
        pointWriter.usePoint(point, amount);

        historyWriter.write(point.getMember(), store, category, HistoryType.EARN, amount);

        return new PointResponseDto(barcode, category, point.getPoints());
    }

}
