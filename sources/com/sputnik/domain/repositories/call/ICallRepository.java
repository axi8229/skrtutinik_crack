package com.sputnik.domain.repositories.call;

import com.huawei.hms.api.FailedBinderCallBack;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.call.DomainCall;
import com.sputnik.domain.entities.call.DomainSipAccount;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.flow.Flow;

/* compiled from: ICallRepository.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001e\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\u0003H&¨\u0006\f"}, d2 = {"Lcom/sputnik/domain/repositories/call/ICallRepository;", "", "acceptCall", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", FailedBinderCallBack.CALLER_ID, "", "getCall", "Lcom/sputnik/domain/entities/call/DomainCall;", "getSipAccount", "Lcom/sputnik/domain/entities/call/DomainSipAccount;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ICallRepository {
    Flow<Resource<Unit>> acceptCall(String callId);

    Flow<Resource<DomainCall>> getCall(String callId);

    Flow<Resource<DomainSipAccount>> getSipAccount();
}
