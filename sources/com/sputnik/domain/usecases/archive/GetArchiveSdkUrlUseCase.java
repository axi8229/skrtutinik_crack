package com.sputnik.domain.usecases.archive;

import com.sputnik.domain.repositories.archive.IArchiveRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetArchiveSdkUrlUseCase.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sputnik/domain/usecases/archive/GetArchiveSdkUrlUseCase;", "", "Lcom/sputnik/domain/repositories/archive/IArchiveRepository;", "repository", "<init>", "(Lcom/sputnik/domain/repositories/archive/IArchiveRepository;)V", "Lcom/sputnik/domain/repositories/archive/IArchiveRepository;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GetArchiveSdkUrlUseCase {
    private final IArchiveRepository repository;

    public GetArchiveSdkUrlUseCase(IArchiveRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }
}
