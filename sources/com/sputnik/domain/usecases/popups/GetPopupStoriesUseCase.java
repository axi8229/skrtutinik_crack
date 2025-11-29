package com.sputnik.domain.usecases.popups;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.popups.DomainPopupStoryStructure;
import com.sputnik.domain.repositories.popups.IPopupStoriesRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: GetPopupStoriesUseCase.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u00062\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/sputnik/domain/usecases/popups/GetPopupStoriesUseCase;", "", "repository", "Lcom/sputnik/domain/repositories/popups/IPopupStoriesRepository;", "(Lcom/sputnik/domain/repositories/popups/IPopupStoriesRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/domain/entities/popups/DomainPopupStoryStructure;", "version", "", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GetPopupStoriesUseCase {
    private final IPopupStoriesRepository repository;

    public GetPopupStoriesUseCase(IPopupStoriesRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    public static /* synthetic */ Flow invoke$default(GetPopupStoriesUseCase getPopupStoriesUseCase, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        return getPopupStoriesUseCase.invoke(i);
    }

    public final Flow<Resource<List<DomainPopupStoryStructure>>> invoke(int version) {
        return this.repository.loadPopupStories(version);
    }
}
