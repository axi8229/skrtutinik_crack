package com.sputnik.domain.usecases.stories;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.entities.stories.DomainStory;
import com.sputnik.domain.repositories.stories.IStoriesRepository;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: GetStoriesUseCase.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J5\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/sputnik/domain/usecases/stories/GetStoriesUseCase;", "", "repository", "Lcom/sputnik/domain/repositories/stories/IStoriesRepository;", "(Lcom/sputnik/domain/repositories/stories/IStoriesRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "", "Lcom/sputnik/domain/entities/stories/DomainStory;", "jwt", "", "locale", "version", "", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GetStoriesUseCase {
    private final IStoriesRepository repository;

    public GetStoriesUseCase(IStoriesRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    public static /* synthetic */ Flow invoke$default(GetStoriesUseCase getStoriesUseCase, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = 1;
        }
        return getStoriesUseCase.invoke(str, str2, i);
    }

    public final Flow<Resource<List<DomainStory>>> invoke(String jwt, String locale, int version) {
        Intrinsics.checkNotNullParameter(jwt, "jwt");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return this.repository.loadStories(jwt, locale, version);
    }
}
