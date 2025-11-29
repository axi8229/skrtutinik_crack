package com.sputnik.domain.usecases.support;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.faq.DomainFaqObject;
import com.sputnik.domain.repositories.support.ISupportRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: GetFaq2UseCase.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J#\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/sputnik/domain/usecases/support/GetFaq2UseCase;", "", "repository", "Lcom/sputnik/domain/repositories/support/ISupportRepository;", "(Lcom/sputnik/domain/repositories/support/ISupportRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/domain/entities/faq/DomainFaqObject;", "locale", "", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GetFaq2UseCase {
    private final ISupportRepository repository;

    public GetFaq2UseCase(ISupportRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    public final Flow<Resource<List<DomainFaqObject>>> invoke(String locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        return this.repository.getFaq(locale);
    }
}
