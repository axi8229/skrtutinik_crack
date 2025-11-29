package com.sputnik.common.di.use_cases.stories;

import com.sputnik.domain.repositories.stories.IStoriesRepository;
import com.sputnik.domain.usecases.stories.GetOnBoardingStoriesUseCase;
import com.sputnik.domain.usecases.stories.GetStoriesUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StoriesUseCaseModule.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\t"}, d2 = {"Lcom/sputnik/common/di/use_cases/stories/StoriesUseCaseModule;", "", "()V", "provideGetOnboardingStoriesUseCase", "Lcom/sputnik/domain/usecases/stories/GetOnBoardingStoriesUseCase;", "repository", "Lcom/sputnik/domain/repositories/stories/IStoriesRepository;", "provideGetStoriesUseCase", "Lcom/sputnik/domain/usecases/stories/GetStoriesUseCase;", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class StoriesUseCaseModule {
    public final GetOnBoardingStoriesUseCase provideGetOnboardingStoriesUseCase(IStoriesRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetOnBoardingStoriesUseCase(repository);
    }

    public final GetStoriesUseCase provideGetStoriesUseCase(IStoriesRepository repository) {
        Intrinsics.checkNotNullParameter(repository, "repository");
        return new GetStoriesUseCase(repository);
    }
}
