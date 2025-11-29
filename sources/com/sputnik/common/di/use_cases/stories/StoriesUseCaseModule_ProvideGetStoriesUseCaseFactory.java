package com.sputnik.common.di.use_cases.stories;

import com.sputnik.domain.repositories.stories.IStoriesRepository;
import com.sputnik.domain.usecases.stories.GetStoriesUseCase;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class StoriesUseCaseModule_ProvideGetStoriesUseCaseFactory implements Factory<GetStoriesUseCase> {
    private final StoriesUseCaseModule module;
    private final Provider<IStoriesRepository> repositoryProvider;

    public StoriesUseCaseModule_ProvideGetStoriesUseCaseFactory(StoriesUseCaseModule storiesUseCaseModule, Provider<IStoriesRepository> provider) {
        this.module = storiesUseCaseModule;
        this.repositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public GetStoriesUseCase get() {
        return provideGetStoriesUseCase(this.module, this.repositoryProvider.get());
    }

    public static StoriesUseCaseModule_ProvideGetStoriesUseCaseFactory create(StoriesUseCaseModule storiesUseCaseModule, Provider<IStoriesRepository> provider) {
        return new StoriesUseCaseModule_ProvideGetStoriesUseCaseFactory(storiesUseCaseModule, provider);
    }

    public static GetStoriesUseCase provideGetStoriesUseCase(StoriesUseCaseModule storiesUseCaseModule, IStoriesRepository iStoriesRepository) {
        return (GetStoriesUseCase) Preconditions.checkNotNullFromProvides(storiesUseCaseModule.provideGetStoriesUseCase(iStoriesRepository));
    }
}
