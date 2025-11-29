package com.sputnik.domain.usecases.auth;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.auth.DomainConfirmResponse;
import com.sputnik.domain.repositories.auth.IAuthRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: ConfirmRegistrationUseCase.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JG\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/sputnik/domain/usecases/auth/ConfirmRegistrationUseCase;", "", "repository", "Lcom/sputnik/domain/repositories/auth/IAuthRepository;", "(Lcom/sputnik/domain/repositories/auth/IAuthRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/auth/DomainConfirmResponse;", "requestId", "", "authCode", "platform", "app", "phone", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConfirmRegistrationUseCase {
    private final IAuthRepository repository;

    public ConfirmRegistrationUseCase(IAuthRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    public final Flow<Resource<DomainConfirmResponse>> invoke(String requestId, String authCode, String platform, String app, String phone) {
        return this.repository.confirm(requestId, authCode, platform, app, phone);
    }
}
