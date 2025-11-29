package com.sputnik.domain.usecases.popups;

import com.sputnik.domain.common.Resource;
import com.sputnik.domain.repositories.popups.IPopupStoriesRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* compiled from: SendPopupStoriesActionUseCase.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J-\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0086\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/sputnik/domain/usecases/popups/SendPopupStoriesActionUseCase;", "", "repository", "Lcom/sputnik/domain/repositories/popups/IPopupStoriesRepository;", "(Lcom/sputnik/domain/repositories/popups/IPopupStoriesRepository;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/sputnik/domain/common/Resource;", "popupId", "", "storyId", "action", "domain"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SendPopupStoriesActionUseCase {
    private final IPopupStoriesRepository repository;

    public SendPopupStoriesActionUseCase(IPopupStoriesRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.repository = repository;
    }

    public final Flow<Resource<Object>> invoke(String popupId, String storyId, String action) {
        Intrinsics.checkNotNullParameter(popupId, "popupId");
        Intrinsics.checkNotNullParameter(storyId, "storyId");
        Intrinsics.checkNotNullParameter(action, "action");
        return this.repository.sendAction(popupId, storyId, action);
    }
}
