package sputnik.axmor.com.sputnik.mappers.call_history;

import com.sputnik.common.AndroidConstants;
import com.sputnik.common.entities.localization.LocalizationLocalModel;
import com.sputnik.common.localization.LocalizationStorage;
import com.sputnik.domain.common.Mapper;
import com.sputnik.domain.entities.call.CallState;
import com.sputnik.domain.entities.call_history.DomainCallHistory;
import com.sputnik.domain.utils.DateUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sputnik.axmor.com.sputnik.entities.call_history.CallHistory;

/* compiled from: DomainCallHistoryToCallHistoryMapper.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lsputnik/axmor/com/sputnik/mappers/call_history/DomainCallHistoryToCallHistoryMapper;", "Lcom/sputnik/domain/common/Mapper;", "Lcom/sputnik/domain/entities/call_history/DomainCallHistory;", "Lsputnik/axmor/com/sputnik/entities/call_history/CallHistory;", "localizationStorage", "Lcom/sputnik/common/localization/LocalizationStorage;", "(Lcom/sputnik/common/localization/LocalizationStorage;)V", "map", "input", "app_huaweiRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DomainCallHistoryToCallHistoryMapper implements Mapper<DomainCallHistory, CallHistory> {
    private final LocalizationStorage localizationStorage;

    public DomainCallHistoryToCallHistoryMapper(LocalizationStorage localizationStorage) {
        Intrinsics.checkNotNullParameter(localizationStorage, "localizationStorage");
        this.localizationStorage = localizationStorage;
    }

    @Override // com.sputnik.domain.common.Mapper
    public CallHistory map(DomainCallHistory input) {
        String phoneLocale;
        Intrinsics.checkNotNullParameter(input, "input");
        LocalizationLocalModel data = this.localizationStorage.getData();
        if (data == null || (phoneLocale = data.getTag()) == null) {
            phoneLocale = AndroidConstants.INSTANCE.getPhoneLocale();
        }
        String imageUrl = input.getImageUrl();
        String videoUrl = input.getVideoUrl();
        String flatUUID = input.getFlatUUID();
        CallState state = input.getState();
        String address = input.getAddress();
        String callId = input.getCallId();
        String createdAt = input.getCreatedAt();
        String dMYTimeFormat = createdAt != null ? DateUtilsKt.toDMYTimeFormat(createdAt, phoneLocale) : null;
        String createdAt2 = input.getCreatedAt();
        String timeFormat = createdAt2 != null ? DateUtilsKt.toTimeFormat(createdAt2) : null;
        String createdAt3 = input.getCreatedAt();
        String dMYFormat = createdAt3 != null ? DateUtilsKt.toDMYFormat(createdAt3, phoneLocale) : null;
        String createdAt4 = input.getCreatedAt();
        return new CallHistory(imageUrl, videoUrl, flatUUID, state, address, callId, dMYTimeFormat, timeFormat, dMYFormat, createdAt4 != null ? Long.valueOf(DateUtilsKt.toNanoDateFormat(createdAt4)) : null, input.getDeviceUuid(), input.getCreatedAt(), false, 4096, null);
    }
}
