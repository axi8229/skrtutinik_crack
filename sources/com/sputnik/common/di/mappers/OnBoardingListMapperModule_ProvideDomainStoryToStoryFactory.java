package com.sputnik.common.di.mappers;

import com.sputnik.common.entities.stories.Story;
import com.sputnik.common.mappers.stories.DomainStoryToStoryMapper;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.stories.DomainStory;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class OnBoardingListMapperModule_ProvideDomainStoryToStoryFactory implements Factory<NullableInputListMapper<DomainStory, Story>> {
    private final Provider<DomainStoryToStoryMapper> mapperProvider;
    private final OnBoardingListMapperModule module;

    public OnBoardingListMapperModule_ProvideDomainStoryToStoryFactory(OnBoardingListMapperModule onBoardingListMapperModule, Provider<DomainStoryToStoryMapper> provider) {
        this.module = onBoardingListMapperModule;
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public NullableInputListMapper<DomainStory, Story> get() {
        return provideDomainStoryToStory(this.module, this.mapperProvider.get());
    }

    public static OnBoardingListMapperModule_ProvideDomainStoryToStoryFactory create(OnBoardingListMapperModule onBoardingListMapperModule, Provider<DomainStoryToStoryMapper> provider) {
        return new OnBoardingListMapperModule_ProvideDomainStoryToStoryFactory(onBoardingListMapperModule, provider);
    }

    public static NullableInputListMapper<DomainStory, Story> provideDomainStoryToStory(OnBoardingListMapperModule onBoardingListMapperModule, DomainStoryToStoryMapper domainStoryToStoryMapper) {
        return (NullableInputListMapper) Preconditions.checkNotNullFromProvides(onBoardingListMapperModule.provideDomainStoryToStory(domainStoryToStoryMapper));
    }
}
