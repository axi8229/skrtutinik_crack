package com.sputnik.domain.usecases.address;

import com.sputnik.domain.repositories.address.IAddressRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeleteCustomAddressUseCase.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sputnik/domain/usecases/address/DeleteCustomAddressUseCase;", "", "Lcom/sputnik/domain/repositories/address/IAddressRepository;", "repository", "<init>", "(Lcom/sputnik/domain/repositories/address/IAddressRepository;)V", "Lcom/sputnik/domain/repositories/address/IAddressRepository;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DeleteCustomAddressUseCase {
    private final IAddressRepository repository;

    public DeleteCustomAddressUseCase(IAddressRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }
}
