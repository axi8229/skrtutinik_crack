package com.sputnik.domain.usecases.auth;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.auth.DomainRequestInfo;
import com.sputnik.domain.repositories.auth.IAuthRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: GetRequestUseCase.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/sputnik/domain/usecases/auth/GetRequestUseCase;", "", "repository", "Lcom/sputnik/domain/repositories/auth/IAuthRepository;", "(Lcom/sputnik/domain/repositories/auth/IAuthRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/auth/DomainRequestInfo;", "requestId", "", "phone", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GetRequestUseCase {
    private final IAuthRepository repository;

    public GetRequestUseCase(IAuthRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    public final Flow<Resource<DomainRequestInfo>> invoke(String requestId, String phone) {
        return this.repository.getRequest(requestId, phone);
    }
}
