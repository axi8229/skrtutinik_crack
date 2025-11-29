package com.sputnik.domain.usecases.fr_service;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.sputnik.domain.common.Resource;
import com.sputnik.domain.repositories.fr_service.IFrServiceRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: UpdateFrUseCase.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\"\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\n\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/sputnik/domain/usecases/fr_service/UpdateFrUseCase;", "T", "", "repository", "Lcom/sputnik/domain/repositories/fr_service/IFrServiceRepository;", "(Lcom/sputnik/domain/repositories/fr_service/IFrServiceRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", RemoteMessageConst.DATA, "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateFrUseCase<T> {
    private final IFrServiceRepository<T> repository;

    public UpdateFrUseCase(IFrServiceRepository<T> repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    public final Flow<Resource<Unit>> invoke(T data) {
        return this.repository.updateFr(data);
    }
}
