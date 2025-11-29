package com.sputnik.domain.repositories.call_history;

import com.huawei.hms.api.FailedBinderCallBack;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.call.DomainCall;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: ICallHistoryRepository.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001c\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0007\u001a\u00020\bH&J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H&¨\u0006\n"}, d2 = {"Lcom/sputnik/domain/repositories/call_history/ICallHistoryRepository;", "T", "", "deleteCall", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/call/DomainCall;", FailedBinderCallBack.CALLER_ID, "", "loadCallHistory", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ICallHistoryRepository<T> {
    Flow<Resource<DomainCall>> deleteCall(String callId);

    Flow<T> loadCallHistory();
}
