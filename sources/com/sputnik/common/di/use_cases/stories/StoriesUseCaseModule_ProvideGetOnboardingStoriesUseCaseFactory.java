package com.sputnik.common.di.use_cases.stories;

import com.sputnik.domain.repositories.stories.IStoriesRepository;
import com.sputnik.domain.usecases.stories.GetOnBoardingStoriesUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class StoriesUseCaseModule_ProvideGetOnboardingStoriesUseCaseFactory implements Factory<GetOnBoardingStoriesUseCase> {
    private final StoriesUseCaseModule module;
    private final Provider<IStoriesRepository> repositoryProvider;

    public StoriesUseCaseModule_ProvideGetOnboardingStoriesUseCaseFactory(StoriesUseCaseModule storiesUseCaseModule, Provider<IStoriesRepository> provider) {
        this.module = storiesUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public GetOnBoardingStoriesUseCase get() {
        return provideGetOnboardingStoriesUseCase(this.module, this.repositoryProvider.get());
    }

    public static StoriesUseCaseModule_ProvideGetOnboardingStoriesUseCaseFactory create(StoriesUseCaseModule storiesUseCaseModule, Provider<IStoriesRepository> provider) {
        return new StoriesUseCaseModule_ProvideGetOnboardingStoriesUseCaseFactory(storiesUseCaseModule, provider);
    }

    public static GetOnBoardingStoriesUseCase provideGetOnboardingStoriesUseCase(StoriesUseCaseModule storiesUseCaseModule, IStoriesRepository iStoriesRepository) {
        return (GetOnBoardingStoriesUseCase) Preconditions.checkNotNullFromProvides(storiesUseCaseModule.provideGetOnboardingStoriesUseCase(iStoriesRepository));
    }
}
