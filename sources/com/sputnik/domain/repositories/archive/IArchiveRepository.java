package com.sputnik.domain.repositories.archive;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.archive.DomainArchiveUrls;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: IArchiveRepository.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/sputnik/domain/repositories/archive/IArchiveRepository;", "", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "Lcom/sputnik/domain/entities/archive/DomainArchiveUrls;", "getArchiveUrls", "()Lkotlinx/coroutines/flow/Flow;", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IArchiveRepository {
    Flow<Resource<DomainArchiveUrls>> getArchiveUrls();
}
