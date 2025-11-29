package com.sputnik.common.viewmodels;

import com.sputnik.common.entities.stories.Story;
import com.sputnik.data.IConfig;
import com.sputnik.data.local.PrefManager;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.stories.DomainStory;
import com.sputnik.domain.usecases.stories.GetOnBoardingStoriesUseCase;
import com.sputnik.domain.usecases.stories.GetStoriesUseCase;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class StoriesViewModel_Factory implements Factory<StoriesViewModel> {
    private final Provider<IConfig> configProvider;
    private final Provider<NullableInputListMapper<DomainStory, Story>> domainStoriesToStoriesMapperProvider;
    private final Provider<GetOnBoardingStoriesUseCase> getOnBoardingStoriesUseCaseProvider;
    private final Provider<GetStoriesUseCase> getStoriesUseCaseProvider;
    private final Provider<PrefManager> prefManagerProvider;

    public StoriesViewModel_Factory(Provider<PrefManager> provider, Provider<IConfig> provider2, Provider<GetOnBoardingStoriesUseCase> provider3, Provider<GetStoriesUseCase> provider4, Provider<NullableInputListMapper<DomainStory, Story>> provider5) {
        this.prefManagerProvider = provider;
        this.configProvider = provider2;
        this.getOnBoardingStoriesUseCaseProvider = provider3;
        this.getStoriesUseCaseProvider = provider4;
        this.domainStoriesToStoriesMapperProvider = provider5;
    }

    @Override // javax.inject.Provider
    public StoriesViewModel get() {
        return newInstance(this.prefManagerProvider.get(), this.configProvider.get(), this.getOnBoardingStoriesUseCaseProvider.get(), this.getStoriesUseCaseProvider.get(), this.domainStoriesToStoriesMapperProvider.get());
    }

    public static StoriesViewModel_Factory create(Provider<PrefManager> provider, Provider<IConfig> provider2, Provider<GetOnBoardingStoriesUseCase> provider3, Provider<GetStoriesUseCase> provider4, Provider<NullableInputListMapper<DomainStory, Story>> provider5) {
        return new StoriesViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static StoriesViewModel newInstance(PrefManager prefManager, IConfig iConfig, GetOnBoardingStoriesUseCase getOnBoardingStoriesUseCase, GetStoriesUseCase getStoriesUseCase, NullableInputListMapper<DomainStory, Story> nullableInputListMapper) {
        return new StoriesViewModel(prefManager, iConfig, getOnBoardingStoriesUseCase, getStoriesUseCase, nullableInputListMapper);
    }
}
