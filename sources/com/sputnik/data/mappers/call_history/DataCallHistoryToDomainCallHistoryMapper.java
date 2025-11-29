package com.sputnik.data.mappers.call_history;

import com.sputnik.data.entities.call_history.DataCallHistory;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.call_history.DomainCallHistory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataCallHistoryToDomainCallHistoryMapper.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/sputnik/data/mappers/call_history/DataCallHistoryToDomainCallHistoryMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/data/entities/call_history/DataCallHistory;", "Lcom/sputnik/domain/entities/call_history/DomainCallHistory;", "()V", "map", "input", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DataCallHistoryToDomainCallHistoryMapper implements Mapper<DataCallHistory, DomainCallHistory> {
    @Override // com.sputnik.domain.common.Mapper
    public DomainCallHistory map(DataCallHistory input) {
        Intrinsics.checkNotNullParameter(input, "input");
        return new DomainCallHistory(input.getCreatedAt(), input.getImageUrl(), input.getVideoUrl(), input.getFlatUUID(), input.getState(), input.getAddress(), input.getCallId(), input.getDeviceUuid());
    }
}
