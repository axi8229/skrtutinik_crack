package com.sputnik.common.di.mappers;

import com.sputnik.common.entities.stories.StoryButton;
import com.sputnik.common.mappers.stories.DomainStoryButtonToStoryButtonMapper;
import com.sputnik.domain.common.NullableInputListMapper;
import com.sputnik.domain.entities.stories.DomainStoriesButton;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class OnBoardingListMapperModule_ProvideDomainStoryButtonToStoryButtonFactory implements Factory<NullableInputListMapper<DomainStoriesButton, StoryButton>> {
    private final Provider<DomainStoryButtonToStoryButtonMapper> mapperProvider;
    private final OnBoardingListMapperModule module;

    public OnBoardingListMapperModule_ProvideDomainStoryButtonToStoryButtonFactory(OnBoardingListMapperModule onBoardingListMapperModule, Provider<DomainStoryButtonToStoryButtonMapper> provider) {
        this.module = onBoardingListMapperModule;
        this.mapperProvider = provider;
    }

    @Override // javax.inject.Provider
    public NullableInputListMapper<DomainStoriesButton, StoryButton> get() {
        return provideDomainStoryButtonToStoryButton(this.module, this.mapperProvider.get());
    }

    public static OnBoardingListMapperModule_ProvideDomainStoryButtonToStoryButtonFactory create(OnBoardingListMapperModule onBoardingListMapperModule, Provider<DomainStoryButtonToStoryButtonMapper> provider) {
        return new OnBoardingListMapperModule_ProvideDomainStoryButtonToStoryButtonFactory(onBoardingListMapperModule, provider);
    }

    public static NullableInputListMapper<DomainStoriesButton, StoryButton> provideDomainStoryButtonToStoryButton(OnBoardingListMapperModule onBoardingListMapperModule, DomainStoryButtonToStoryButtonMapper domainStoryButtonToStoryButtonMapper) {
        return (NullableInputListMapper) Preconditions.checkNotNullFromProvides(onBoardingListMapperModule.provideDomainStoryButtonToStoryButton(domainStoryButtonToStoryButtonMapper));
    }
}
