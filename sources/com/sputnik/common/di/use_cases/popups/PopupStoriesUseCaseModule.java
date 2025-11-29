package com.sputnik.common.di.use_cases.popups;

import com.sputnik.domain.repositories.popups.IPopupStoriesRepository;
import com.sputnik.domain.usecases.popups.GetPopupStoriesUseCase;
import com.sputnik.domain.usecases.popups.SendPopupStoriesActionUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PopupStoriesUseCaseModule.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\t"}, d2 = {"Lcom/sputnik/common/di/use_cases/popups/PopupStoriesUseCaseModule;", "", "()V", "provideGetPopupStoriesUseCase", "Lcom/sputnik/domain/usecases/popups/GetPopupStoriesUseCase;", "repository", "Lcom/sputnik/domain/repositories/popups/IPopupStoriesRepository;", "provideSendPopupStoriesUseCase", "Lcom/sputnik/domain/usecases/popups/SendPopupStoriesActionUseCase;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PopupStoriesUseCaseModule {
    public final GetPopupStoriesUseCase provideGetPopupStoriesUseCase(IPopupStoriesRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetPopupStoriesUseCase(repository);
    }

    public final SendPopupStoriesActionUseCase provideSendPopupStoriesUseCase(IPopupStoriesRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new SendPopupStoriesActionUseCase(repository);
    }
}
