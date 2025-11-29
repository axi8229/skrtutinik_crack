package com.sputnik.domain.usecases.call;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.call.DomainSipAccount;
import com.sputnik.domain.repositories.call.ICallRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: GetSipAccountUseCase.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/sputnik/domain/usecases/call/GetSipAccountUseCase;", "", "repository", "Lcom/sputnik/domain/repositories/call/ICallRepository;", "(Lcom/sputnik/domain/repositories/call/ICallRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/call/DomainSipAccount;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GetSipAccountUseCase {
    private final ICallRepository repository;

    public GetSipAccountUseCase(ICallRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    public final Flow<Resource<DomainSipAccount>> invoke() {
        return this.repository.getSipAccount();
    }
}
